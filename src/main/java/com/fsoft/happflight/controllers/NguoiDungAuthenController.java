package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.DangNhapDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiMatKhauDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiThongTinNguoiDungDTO;
import com.fsoft.happflight.services.nguoi_dung.impl.NguoiDungAuthenServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.RoleServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.TaiKhoanServiceImpl;
import com.fsoft.happflight.utils.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/nguoi-dung")
public class NguoiDungAuthenController {

    @Autowired
    private TaiKhoanServiceImpl taiKhoanService;

    @Autowired
    private NguoiDungAuthenServiceImpl nguoiDungService;

    @Autowired
    private RoleServiceImpl roleService;

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
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //quen mat khau


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

    @PostMapping("/thay-doi-thong-tin-nguoi-dung")
    public ResponseEntity<?> thayDoiThongTinNguoiDung(@Validated @ModelAttribute ThayDoiThongTinNguoiDungDTO thayDoiThongTinNguoiDungDTO,
                                                      @CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (JwtProvider.validateToken(jwtToken)) {
            nguoiDungService.saveThayDoiNguoiDung(thayDoiThongTinNguoiDungDTO);
            responseBody.put("message", "Thay đổi thông tin người dùng thành công;");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Thay đổi thông tin người dùng không thành công");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}
