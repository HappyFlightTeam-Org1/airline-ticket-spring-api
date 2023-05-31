package com.fsoft.happflight.services.hoa_don;

import com.fsoft.happflight.entities.hoa_don.HoaDon;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
public interface IHoaDonService {

	HoaDon create(HoaDon hoaDon);

	HoaDon update(HoaDon hoaDon);

	HoaDon findById(String maHoaDon);

}
