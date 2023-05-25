package com.fsoft.happflight.services.nguoi_dung;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiThongTinNguoiDungDTO;

public interface INguoiDungAuthenService {
    boolean validateEmail(String email);

    void saveNguoiDung(DangKyDTO dangKyDTO);

    void saveThayDoiNguoiDung(ThayDoiThongTinNguoiDungDTO thayDoiThongTinNguoiDungDTO);

    String getUsernameFromNguoiDung(String email);
}
