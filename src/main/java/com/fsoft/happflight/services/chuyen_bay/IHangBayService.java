package com.fsoft.happflight.services.chuyen_bay;

import java.util.List;

import com.fsoft.happflight.entities.chuyen_bay.HangBay;

// TODO: Auto-generated Javadoc
/**
 * The Interface IHangBayService.
 */
public interface IHangBayService {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<HangBay> findAll();

	/**
	 * Find by id.
	 *
	 * @param maHangBay the ma hang bay
	 * @return the hang bay
	 */
	HangBay findById(String maHangBay);
}
