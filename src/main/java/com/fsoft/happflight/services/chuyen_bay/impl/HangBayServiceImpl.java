package com.fsoft.happflight.services.chuyen_bay.impl;

import java.util.List;

import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import com.fsoft.happflight.repositories.chuyen_bay.IHangBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IHangBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class HangBayServiceImpl.
 */
@Service
public class HangBayServiceImpl implements IHangBayService {
	@Autowired
	IHangBayRepository hangBayRepository;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<HangBay> findAll() {
		return hangBayRepository.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param maHangBay the ma hang bay
	 * @return the hang bay
	 */
	@Override
	public HangBay findById(String maHangBay) {
		return hangBayRepository.findById(maHangBay).orElse(null);
	}

}
