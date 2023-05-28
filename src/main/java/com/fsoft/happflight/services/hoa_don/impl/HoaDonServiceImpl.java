package com.fsoft.happflight.services.hoa_don.impl;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.repositories.hoa_don.IHoaDonRepository;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@Service
public class HoaDonServiceImpl implements IHoaDonService {

	@Autowired
	private IHoaDonRepository hoaDonRepository;

	/**
	 * @author DuyNT58
	 * @TODO tao moi HoaDon
	 * @UPDATE_DATE May 26, 2023
	 * @param hoaDon
	 * @return
	 */
	@Override
	public HoaDon create(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	/**
	 * @author DuyNT58
	 * @TODO cap nhat HoaDon
	 * @UPDATE_DATE May 26, 2023
	 * @param hoaDon
	 * @return HoaDon
	 */
	@Override
	public HoaDon update(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	/**
	 * @author DuyNT58
	 * @TODO tim kiem hoa don theo ma hoa don
	 * @UPDATE_DATE May 26, 2023
	 * @param maHoaDon
	 * @return HoaDon
	 */
	@Override
	public HoaDon findById(String maHoaDon) {
		return hoaDonRepository.findById(maHoaDon).orElse(null);
	}

}
