package com.fsoft.happflight.services.nguoi_dung;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiThongTinNguoiDungDTO;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;

public interface INguoiDungAuthenService {
    boolean validateEmail(String email);

    void saveNguoiDung(DangKyDTO dangKyDTO);

    boolean saveThayDoiNguoiDung(NguoiDung nguoiDung, ThayDoiThongTinNguoiDungDTO thayDoiThongTinNguoiDungDTO);

    String getUsernameFromNguoiDung(String email);

    NguoiDung getWithUsername(String username);
}
