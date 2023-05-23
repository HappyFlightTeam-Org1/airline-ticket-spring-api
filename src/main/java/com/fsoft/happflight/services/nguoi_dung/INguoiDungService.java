package com.fsoft.happflight.services.nguoi_dung;


import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INguoiDungService {

    NguoiDung findById(String email);

    List<NguoiDung> getAllNguoiDungs();

    Page<NguoiDung> getAllNguoiDungsPage(Pageable pageable);

    Page<NguoiDung> findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining(Pageable pageable, String hoVaTen, String soDienThoai, String email);
}
