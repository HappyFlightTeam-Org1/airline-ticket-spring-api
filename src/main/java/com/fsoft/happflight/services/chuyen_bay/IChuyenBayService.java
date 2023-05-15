package com.fsoft.happflight.services.chuyen_bay;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

import java.util.List;

public interface IChuyenBayService {

    void save(ChuyenBay chuyenBay);

    List<ChuyenBay> finAll();

//    void insertChuyenBay(String maChuyenBay, String diemDi, String diemDen, LocalDate ngayKhoiHanh,
//                         LocalTime gioKhoiHanh, LocalTime gioHaCanh, String thoiGianBay, String giaVe, String KLHanhLy,
//                         String trangThaiVanHanh, Long maMayBay, String maHangBay);

}
