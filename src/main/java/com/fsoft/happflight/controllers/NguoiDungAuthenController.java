package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.nguoi_dung.*;
import com.fsoft.happflight.services.nguoi_dung.impl.NguoiDungAuthenServiceImpl;
import com.fsoft.happflight.services.nguoi_dung.impl.QuocTichServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.RoleServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.TaiKhoanServiceImpl;
import com.fsoft.happflight.utils.email.EmailService;
import com.fsoft.happflight.utils.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/nguoi-dung")
public class NguoiDungAuthenController {

    @Autowired
    private TaiKhoanServiceImpl taiKhoanService;

    @Autowired
    private NguoiDungAuthenServiceImpl nguoiDungService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private QuocTichServiceImpl quocTichService;

    @PostMapping("/dang-nhap")
    public ResponseEntity<?> dangNhap(@Validated @ModelAttribute DangNhapDTO dangNhapDTO) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (taiKhoanService.validateLogin(dangNhapDTO)) {
            responseBody.put("jwt", JwtProvider.generateToken(dangNhapDTO.getTenTaiKhoan()));
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Sai tên tài khoản hoặc mật khẩu");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKy(@Validated @ModelAttribute DangKyDTO dangKyDTO) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (!taiKhoanService.validateTenTaiKhoan(dangKyDTO.getTenTaiKhoan())
                && !nguoiDungService.validateEmail(dangKyDTO.getDiaChiEmail())) {
            taiKhoanService.saveNewTaiKhoan(dangKyDTO);
            roleService.saveTaiKhoanWithUserRole(dangKyDTO.getTenTaiKhoan());
            nguoiDungService.saveNguoiDung(dangKyDTO);
            responseBody.put("message", "Đăng ký thành công");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Tên tài khoản hoặc email bị trùng lăp");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    //quen mat khau
    @PostMapping("/email-dat-lai-mat-khau")
    public ResponseEntity<?> emailDatLaiMatKhau(@Validated @ModelAttribute EmailDatLaiMatKhauDTO emailDatLaiMatKhauDTO) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (nguoiDungService.validateEmail(emailDatLaiMatKhauDTO.getEmail())) {
            emailService.sendResetEmail(emailDatLaiMatKhauDTO.getEmail(),
                    JwtProvider.generateResetToken(nguoiDungService.getUsernameFromNguoiDung(emailDatLaiMatKhauDTO.getEmail())));
            responseBody.put("message", "Gửi email thành công");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Email không tồn tại");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/dat-lai-mat-khau")
    public ResponseEntity<?> datLaiMatKhau(@Validated @ModelAttribute DatLaiMatKhauDTO datLaiMatKhauDTO) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (JwtProvider.validateToken(datLaiMatKhauDTO.getResetToken())) {
            taiKhoanService.savePasswordChange(datLaiMatKhauDTO.getMatKhauMoi(),
                    JwtProvider.getUsernameFromToken(datLaiMatKhauDTO.getResetToken()));
            responseBody.put("message", "Đặt lại mật khẩu thành công");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Đặt lại mật khẩu không thành công");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PostMapping("/thay-doi-mat-khau")
    public ResponseEntity<?> thayDoiMatKhau(@Validated @ModelAttribute ThayDoiMatKhauDTO thayDoiMatKhauDTO,
                                            @CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (taiKhoanService.validatePassword(JwtProvider.getUsernameFromToken(jwtToken), thayDoiMatKhauDTO.getMatKhauHienTai())
                && thayDoiMatKhauDTO.getMatKhauMoi().equals(thayDoiMatKhauDTO.getXacNhanMatKhauMoi())
                && JwtProvider.validateToken(jwtToken)) {
            taiKhoanService.savePasswordChange(thayDoiMatKhauDTO.getMatKhauMoi(), JwtProvider.getUsernameFromToken(jwtToken));
            responseBody.put("message", "Thay đổi mật khẩu thành công");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Mật khẩu hiện tại không trùng khớp");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/lay-thong-tin-nguoi-dung")
    public ResponseEntity<?> layThongTinNguoiDung(@CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        if (JwtProvider.validateToken(jwtToken)) {
            return new ResponseEntity<>(nguoiDungService.getWithUsername(JwtProvider.getUsernameFromToken(jwtToken)), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/thay-doi-thong-tin-nguoi-dung")
    public ResponseEntity<?> thayDoiThongTinNguoiDung(@Validated @ModelAttribute ThayDoiThongTinNguoiDungDTO thayDoiThongTinNguoiDungDTO,
                                                      @CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (JwtProvider.validateToken(jwtToken) && nguoiDungService.saveThayDoiNguoiDung(
                nguoiDungService.getWithUsername(JwtProvider.getUsernameFromToken(jwtToken)),
                thayDoiThongTinNguoiDungDTO)) {
            responseBody.put("message", "Thay đổi thông tin người dùng thành công;");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Thay đổi thông tin người dùng không thành công");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/danh-sach-quoc-tich")
    public ResponseEntity<?> getAllQuocTich() {
        return new ResponseEntity<>(quocTichService.getAll(), HttpStatus.OK);
    }
}
