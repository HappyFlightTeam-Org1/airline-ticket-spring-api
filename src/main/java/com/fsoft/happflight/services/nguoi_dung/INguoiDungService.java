package com.fsoft.happflight.services.nguoi_dung;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;

public interface INguoiDungService {
    boolean validateEmail(String email);

    void saveNguoiDung(DangKyDTO dangKyDTO);
}
