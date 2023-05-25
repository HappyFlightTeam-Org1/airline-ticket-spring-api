package com.fsoft.happflight.services.hoa_don.impl;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.repositories.hoa_don.IHoaDonRepository;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonServiceImpl implements IHoaDonService {

	@Autowired
	private IHoaDonRepository hoaDonRepository;

	@Override
	public HoaDon create(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	@Override
	public HoaDon update(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	@Override
	public HoaDon findById(String maHoaDon) {
		return hoaDonRepository.findById(maHoaDon).orElse(null);
	}

}
