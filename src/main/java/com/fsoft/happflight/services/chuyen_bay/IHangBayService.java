package com.fsoft.happflight.services.chuyen_bay;

import java.util.List;

import com.fsoft.happflight.entities.chuyen_bay.HangBay;

public interface IHangBayService {
	List<HangBay> findAll();

	HangBay findById(String maHangBay);
}
