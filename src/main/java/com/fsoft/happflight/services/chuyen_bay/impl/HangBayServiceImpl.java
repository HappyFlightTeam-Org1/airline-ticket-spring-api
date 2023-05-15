package com.fsoft.happflight.services.chuyen_bay.impl;

import java.util.List;

import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import com.fsoft.happflight.repositories.chuyen_bay.IHangBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IHangBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HangBayServiceImpl implements IHangBayService {
	@Autowired
	IHangBayRepository hangBayRepository;

	@Override
	public List<HangBay> findAll() {
		// TODO Auto-generated method stub
		return hangBayRepository.findAll();
	}

	@Override
	public HangBay findById(String maHangBay) {
		// TODO Auto-generated method stub
		return hangBayRepository.findById(maHangBay).orElse(null);
	}

}
