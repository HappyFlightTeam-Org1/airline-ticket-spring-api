package com.fsoft.happflight.services.tai_khoan.impl;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.DangNhapDTO;
import com.fsoft.happflight.entities.tai_khoan.TaiKhoan;
import com.fsoft.happflight.repositories.tai_khoan.IRoleRepository;
import com.fsoft.happflight.repositories.tai_khoan.ITaiKhoanRepository;
import com.fsoft.happflight.services.tai_khoan.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService {
    @Autowired
    private ITaiKhoanRepository taiKhoanRepository;

    @Override
    public boolean validateLogin(DangNhapDTO dangNhapDTO) {
        return taiKhoanRepository.getTaiKhoan(dangNhapDTO.getTenTaiKhoan(), dangNhapDTO.getMatKhau()) != null;
    }

    @Override
    public boolean validateTenTaiKhoan(String tenTaiKhoan) {
        return taiKhoanRepository.getTaiKhoanByTenTaiKhoan(tenTaiKhoan) != null;
    }

    @Override
    public void saveNewTaiKhoan(DangKyDTO dangKyDTO) {
        TaiKhoan taiKhoanMoi = new TaiKhoan(dangKyDTO.getTenTaiKhoan(), dangKyDTO.getMatKhau());
        taiKhoanRepository.save(taiKhoanMoi);
    }

    public TaiKhoan getByUsername(String username) {
        return taiKhoanRepository.getTaiKhoanByTenTaiKhoan(username);
    }

    @Override
    public boolean validatePassword(String password) {
        return taiKhoanRepository.getTaiKhoanByMatKhau(password) != null;
    }

    @Override
    public void savePasswordChange(String newPassword, String username) {
        taiKhoanRepository.savePasswordChange(newPassword, username);
    }
}
