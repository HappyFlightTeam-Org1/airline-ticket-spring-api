package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.DangNhapDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiMatKhauDTO;
import com.fsoft.happflight.services.nguoi_dung.impl.NguoiDungServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.RoleServiceImpl;
import com.fsoft.happflight.services.tai_khoan.impl.TaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/nguoi-dung")
public class NguoiDungController {
    /*
    * Dang ky
    * Dang nhap
    * Quen mat khau
    * Thay doi mat khau
    * Thay doi thong tin nguoi dung
    * */

    @Autowired
    private TaiKhoanServiceImpl taiKhoanService;

    @Autowired
    private NguoiDungServiceImpl nguoiDungService;

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/dang-nhap")
    public ResponseEntity<?> dangNhap(@Validated @ModelAttribute DangNhapDTO dangNhapDTO) {
        if (taiKhoanService.validateLogin(dangNhapDTO)) {

            return new ResponseEntity<>(dangNhapDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKy(@Validated @ModelAttribute DangKyDTO dangKyDTO) {
        if (!taiKhoanService.validateTenTaiKhoan(dangKyDTO.getTenTaiKhoan())
                && !nguoiDungService.validateEmail(dangKyDTO.getDiaChiEmail())) {
            taiKhoanService.saveNewTaiKhoan(dangKyDTO);
            roleService.saveTaiKhoanWithUserRole(dangKyDTO.getTenTaiKhoan());
            nguoiDungService.saveNguoiDung(dangKyDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //quen mat khau

    @Transactional
    @PostMapping("/thay-doi-mat-khau")
    public ResponseEntity<?> thayDoiMatKhau(@Validated @ModelAttribute ThayDoiMatKhauDTO thayDoiMatKhauDTO) {
        if (taiKhoanService.validatePassword(thayDoiMatKhauDTO.getMatKhauHienTai())
                && thayDoiMatKhauDTO.getMatKhauMoi().equals(thayDoiMatKhauDTO.getXacNhanMatKhauMoi())) {
            taiKhoanService.savePasswordChange(thayDoiMatKhauDTO.getMatKhauMoi(), "test");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/thay-doi-thong-tin-nguoi-dung")
    public ResponseEntity<?> thayDoiThongTinNguoiDung() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
