package com.fsoft.happflight.services.chuyen_bay.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsoft.happflight.entities.chuyen_bay.SanBay;
import com.fsoft.happflight.repositories.chuyen_bay.ISanBayRepository;
import com.fsoft.happflight.services.chuyen_bay.ISanBayService;

@Service
public class SanBayServiceImpl implements ISanBayService {
@Autowired
ISanBayRepository sanBayRepository;
	@Override
	public List<SanBay> findAll() {
		return sanBayRepository.findAll();
	}

}
