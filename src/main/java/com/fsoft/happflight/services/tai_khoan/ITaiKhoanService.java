package com.fsoft.happflight.services.tai_khoan;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.DangNhapDTO;
import com.fsoft.happflight.entities.tai_khoan.TaiKhoan;

public interface ITaiKhoanService {
    boolean validateLogin(DangNhapDTO dangNhapDTO);

    boolean validateTenTaiKhoan(String tenTaiKhoan);

    void saveNewTaiKhoan(DangKyDTO dangKyDTO);

    TaiKhoan getByUsername(String username);

    boolean validatePassword(String password);

    void savePasswordChange(String newPassword, String username);
}
