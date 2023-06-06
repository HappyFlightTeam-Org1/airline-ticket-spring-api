package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.nguoi_dung.*;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.services.nguoi_dung.impl.NguoiDungAuthenServiceImpl;
import com.fsoft.happflight.services.nguoi_dung.impl.QuocTichServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.RoleServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.TaiKhoanServiceImpl;
import com.fsoft.happflight.services.email.EmailService;
import com.fsoft.happflight.utils.consts.RoleNameConsts;
import com.fsoft.happflight.utils.jwt.JwtProvider;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * RESTful controller endpoint for DangNhap, DangKy, QuenMatKhau, ResetMatKhau, ThayDoiThongTinNguoiDung
 */
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

    /**
     * Perform login function
     * @param dangNhapDTO FormData from client request
     * @return JSON object (Http: 200) contain: email, jwt token if valid credentials<br>
     *         JSON object (Http: 400) contain: invalid message if invalid credentials<br>
     */
    @PostMapping("/dang-nhap")
    public ResponseEntity<?> dangNhap(@Validated @ModelAttribute DangNhapDTO dangNhapDTO) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (taiKhoanService.validateLogin(dangNhapDTO)) {
            NguoiDung nguoiDung = nguoiDungService.getWithUsername(dangNhapDTO.getTenTaiKhoan());
            responseBody.put("email", nguoiDung.getEmail());
            responseBody.put("jwt", JwtProvider.generateToken(dangNhapDTO.getTenTaiKhoan()));
            responseBody.put("role", roleService.getRoleFromTaiKhoan(dangNhapDTO.getTenTaiKhoan()));

            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Sai tên tài khoản hoặc mật khẩu");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * Perform register, save to database if valid register data
     * @param dangKyDTO FormData from client request
     * @return JSON object (Http: 200) contain: success message if valid register data<br>
     *         JSON object (Http: 400) contain: failure message if invalid register data<br>
     */
    @Transactional
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKy(@Validated @ModelAttribute DangKyDTO dangKyDTO) {
        HashMap<String, String> responseBody = new HashMap<>();
        if (!taiKhoanService.validateTenTaiKhoan(dangKyDTO.getTenTaiKhoan())
                && !nguoiDungService.validateEmail(dangKyDTO.getDiaChiEmail())) {
            taiKhoanService.saveNewTaiKhoan(dangKyDTO);
            roleService.saveTaiKhoanWithUserRole(dangKyDTO.getTenTaiKhoan());
            nguoiDungService.saveNguoiDung(dangKyDTO);
            emailService.sendRegisterSuccessfulEmail(dangKyDTO.getDiaChiEmail());
            responseBody.put("message", "Đăng ký thành công");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
        responseBody.put("message", "Tên tài khoản hoặc email bị trùng lăp");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    /**
     * Send reset email to user if email exist in database
     * @param emailDatLaiMatKhauDTO FormData from client request
     * @return JSON object (Http: 200) contain: success message if valid email<br>
     *         JSON object (Http: 400) contain: failure message if invalid email<br>
     */
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

    /**
     * Save new password to database if provided valid reset token
     * @param datLaiMatKhauDTO FormData from client request
     * @return JSON object (Http: 200) contain: success message if valid reset token<br>
     *         JSON object (Http: 400) contain: failure message if invalid reset token<br>
     */
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

    /**
     * Save change password to database if provided valid current password
     * @param thayDoiMatKhauDTO FormData from client request
     * @param jwtToken JWT login token
     * @return JSON object (Http: 200) contain: success message if valid current password<br>
     *         JSON object (Http: 400) contain: failure message if invalid current password<br>
     */
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

    /**
     * Get current login NguoiDung info
     * @param jwtToken JWT login token sent from client
     * @return JSON object (Http: 200) contain: NguoiDung info
     */
    @GetMapping("/lay-thong-tin-nguoi-dung")
    public ResponseEntity<?> layThongTinNguoiDung(@CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        if (JwtProvider.validateToken(jwtToken)) {
            return new ResponseEntity<>(nguoiDungService.getWithUsername(JwtProvider.getUsernameFromToken(jwtToken)), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Save change to NguoiDung info
     * @param thayDoiThongTinNguoiDungDTO FormData sent from client
     * @param jwtToken JWT login token sent from client
     * @return JSON object (Http: 200) contain: success message if valid JWT login token<br>
     *         JSON object (Http: 400) contain: failure message if invalid JWT login token
     */
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

    /**
     * Get all quoc tich from quoc_tich table in database
     * @return JSON object (Http: 200) contain: list of quoc tich<br>
     */
    @GetMapping("/danh-sach-quoc-tich")
    public ResponseEntity<?> getAllQuocTich() {
        return new ResponseEntity<>(quocTichService.getAll(), HttpStatus.OK);
    }


    /**
     * Perform logical delete on nguoi_dung
     * @param email nguoi_dung email
     * @param jwtToken login token
     * @return
     */
    @PostMapping("/delete-nguoi-dung")
    public ResponseEntity<?> deleteNguoiDung(String email,
                                             @CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        HashMap<String, String> responseBody = new HashMap<>();

        if (email == null) {
            responseBody.put("email", "This field is required");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        if (!JwtProvider.validateToken(jwtToken)) {
            responseBody.put("message", "Invalid JWT token");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        String username = JwtProvider.getUsernameFromToken(jwtToken);
        if (!roleService.getRoleFromTaiKhoan(username).equals(RoleNameConsts.ROLE_ADMIN)) {
            responseBody.put("message", "Unathorized credentials");
            return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
        }

        if (!nguoiDungService.validateEmail(email)) {
            responseBody.put("message", "Invalid email");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        nguoiDungService.deleteNguoiDung(email);
        responseBody.put("message", "Delete successfully");
//        emailService.sendDeleteEmail(email);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping("/remove-delete-nguoi-dung")
    public ResponseEntity<?> removeDeleteNguoiDung(String email,
                                                   @CookieValue(value = "jwt", defaultValue = "") String jwtToken) {
        HashMap<String, String> responseBody = new HashMap<>();

        if (email == null) {
            responseBody.put("email", "This field is required");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        if (!JwtProvider.validateToken(jwtToken)) {
            responseBody.put("message", "Invalid JWT token");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        String username = JwtProvider.getUsernameFromToken(jwtToken);
        if (!roleService.getRoleFromTaiKhoan(username).equals(RoleNameConsts.ROLE_ADMIN)) {
            responseBody.put("message", "Unathorized credentials");
            return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
        }

        if (!nguoiDungService.validateEmail(email)) {
            responseBody.put("message", "Invalid email");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        nguoiDungService.removeDeleteNguoiDung(email);
        responseBody.put("message", "Remove delete successfully");
//        emailService.sendRemoveDeleteEmail(email);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/google-login")
    public ResponseEntity<?> googleLogin(GoogleLoginDTO googleLoginDTO) {
        HashMap<String, String> responseBody = new HashMap<>();

        if (!nguoiDungService.validateEmail(googleLoginDTO.getEmail())) {
            DangKyDTO dangKyDTO = new DangKyDTO(
                    googleLoginDTO.getEmail(),
                    googleLoginDTO.getEmail(),
                    "",
                    googleLoginDTO.getGoogleId(),
                    "",
                    googleLoginDTO.getName(),
                    "",
                    "",
                    "",
                    48
            );
            taiKhoanService.saveNewTaiKhoan(dangKyDTO);
            roleService.saveTaiKhoanWithUserRole(dangKyDTO.getTenTaiKhoan());
            nguoiDungService.saveNguoiDung(dangKyDTO);
        }
        responseBody.put("email", googleLoginDTO.getEmail());
        NguoiDung nguoiDung = nguoiDungService.getWithEmail(googleLoginDTO.getEmail());
        responseBody.put("jwt", JwtProvider.generateToken(nguoiDung.getTaiKhoan().getTenTaiKhoan()));
        responseBody.put("role", roleService.getRoleFromTaiKhoan(nguoiDung.getTaiKhoan().getTenTaiKhoan()));

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping("/validate-email")
    public ResponseEntity<?> validateEmail(String email) {
        HashMap<String, String> responseBody = new HashMap<>();

        if (email == null) {
            responseBody.put("email", "This field is required");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }

        if (nguoiDungService.validateEmail(email)) {
            responseBody.put("message", "This email is exist");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }

        responseBody.put("message", "This email is not exist");
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
