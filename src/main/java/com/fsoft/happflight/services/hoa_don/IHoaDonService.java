package com.fsoft.happflight.services.hoa_don;

import com.fsoft.happflight.entities.hoa_don.HoaDon;

public interface IHoaDonService {

	HoaDon create(HoaDon hoaDon);

	HoaDon update(HoaDon hoaDon);

	HoaDon findById(String maHoaDon);

}
