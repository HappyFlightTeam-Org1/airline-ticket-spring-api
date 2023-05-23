package com.fsoft.happflight.services.nguoi_dung.impl;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiThongTinNguoiDungDTO;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungAuthenRepository;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungAuthenService;
import com.fsoft.happflight.services.tai_khoan.impl.TaiKhoanServiceImpl;
import com.fsoft.happflight.utils.consts.TrangThaiXoaConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungAuthenServiceImpl implements INguoiDungAuthenService {
    @Autowired
    private INguoiDungAuthenRepository nguoiDungRepository;

    @Autowired
    private QuocTichServiceImpl quocTichService;

    @Autowired
    private TaiKhoanServiceImpl taiKhoanService;

    @Override
    public boolean validateEmail(String email) {
        return nguoiDungRepository.getNguoiDungByEmail(email) != null;
    }

    @Override
    public void saveNguoiDung(DangKyDTO dangKyDTO) {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setEmail(dangKyDTO.getDiaChiEmail());
        nguoiDung.setSoDienThoai(dangKyDTO.getSoDienThoai());
        nguoiDung.setHoVaTen(dangKyDTO.getHoVaTen());
        nguoiDung.setNgaySinh(dangKyDTO.getNgaySinh());
        nguoiDung.setDiaChi(dangKyDTO.getDiaChi());
        nguoiDung.setHoChieu(dangKyDTO.getHoChieu());
        nguoiDung.setGioiTinh(dangKyDTO.getGioiTinh());
        nguoiDung.setTrangThaiXoa(TrangThaiXoaConsts.ACTIVE);
        nguoiDung.setQuocTich(quocTichService.getById(dangKyDTO.getQuocTich()));
        nguoiDung.setTaiKhoan(taiKhoanService.getByUsername(dangKyDTO.getTenTaiKhoan()));
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void saveThayDoiNguoiDung(ThayDoiThongTinNguoiDungDTO thayDoiThongTinNguoiDungDTO) {
        NguoiDung nguoiDung = nguoiDungRepository.getReferenceById(thayDoiThongTinNguoiDungDTO.getDiaChiEmail());

        nguoiDung.setSoDienThoai(thayDoiThongTinNguoiDungDTO.getSoDienThoai());
        nguoiDung.setHoVaTen(thayDoiThongTinNguoiDungDTO.getHoVaTen());
        nguoiDung.setNgaySinh(thayDoiThongTinNguoiDungDTO.getNgaySinh());
        nguoiDung.setDiaChi(thayDoiThongTinNguoiDungDTO.getDiaChi());
        nguoiDung.setHoChieu(thayDoiThongTinNguoiDungDTO.getHoChieu());
        nguoiDung.setGioiTinh(thayDoiThongTinNguoiDungDTO.getGioiTinh());
        nguoiDung.setQuocTich(quocTichService.getById(thayDoiThongTinNguoiDungDTO.getQuocTich()));

        nguoiDungRepository.save(nguoiDung);
    }
}
