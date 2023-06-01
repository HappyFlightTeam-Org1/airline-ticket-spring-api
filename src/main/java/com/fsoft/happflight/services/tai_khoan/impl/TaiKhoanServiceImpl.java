package com.fsoft.happflight.services.tai_khoan.impl;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.DangNhapDTO;
import com.fsoft.happflight.entities.tai_khoan.TaiKhoan;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;
import com.fsoft.happflight.repositories.tai_khoan.IRoleRepository;
import com.fsoft.happflight.repositories.tai_khoan.ITaiKhoanRepository;
import com.fsoft.happflight.services.tai_khoan.ITaiKhoanService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService {
    @Autowired
    private ITaiKhoanRepository taiKhoanRepository;

    @Autowired
    private INguoiDungRepository nguoiDungRepository;

    @Override
    public boolean validateLogin(DangNhapDTO dangNhapDTO) {
        TaiKhoan taiKhoan = taiKhoanRepository.getTaiKhoanByTenTaiKhoan(dangNhapDTO.getTenTaiKhoan());
        return taiKhoan != null
                && BCrypt.checkpw(dangNhapDTO.getMatKhau(), taiKhoan.getMatKhau())
                && nguoiDungRepository.getNguoiDungByTenTaiKhoan(dangNhapDTO.getTenTaiKhoan()) != null;
    }

    @Override
    public boolean validateTenTaiKhoan(String tenTaiKhoan) {
        return taiKhoanRepository.getTaiKhoanByTenTaiKhoan(tenTaiKhoan) != null;
    }

    @Override
    public void saveNewTaiKhoan(DangKyDTO dangKyDTO) {
        String hashedPassword = BCrypt.hashpw(dangKyDTO.getMatKhau(), BCrypt.gensalt());
        TaiKhoan taiKhoanMoi = new TaiKhoan(dangKyDTO.getTenTaiKhoan(), hashedPassword);
        taiKhoanRepository.save(taiKhoanMoi);
    }

    @Override
    public TaiKhoan getByUsername(String username) {
        return taiKhoanRepository.getTaiKhoanByTenTaiKhoan(username);
    }


    @Override
    public boolean validatePassword(String username, String password) {
        TaiKhoan taiKhoan = taiKhoanRepository.getTaiKhoanByTenTaiKhoan(username);
        return taiKhoan != null && BCrypt.checkpw(password, taiKhoan.getMatKhau());
    }

    @Override
    public void savePasswordChange(String newPassword, String username) {
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        taiKhoanRepository.savePasswordChange(hashedPassword, username);
    }
}
