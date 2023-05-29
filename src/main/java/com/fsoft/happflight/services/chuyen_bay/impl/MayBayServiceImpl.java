package com.fsoft.happflight.services.chuyen_bay.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.repositories.chuyen_bay.IMayBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IMayBayService;


/**
 * The Class MayBayServiceImpl.
 */
@Service
public class MayBayServiceImpl implements IMayBayService {
	
	/** The may bay repository. */
	@Autowired
	IMayBayRepository mayBayRepository;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<MayBay> findAll() {
		return mayBayRepository.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param maMayBay the ma may bay
	 * @return the may bay
	 */
	@Override
	public MayBay findById(Long maMayBay) {
		return mayBayRepository.findById(maMayBay).orElse(null);
	}

}