package com.fsoft.happflight.services.nguoi_dung.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;

@Service
public class NguoiDungServiceImpl implements INguoiDungService{

	@Autowired
	private INguoiDungRepository iNguoiDungRepository;
	
	@Override
	public List<NguoiDung> getAllNguoiDungs() {
		
		return iNguoiDungRepository.getAllNguoiDungs();
	}

	@Override
	public Page<NguoiDung> getAllNguoiDungsPage(Pageable pageable) {
		
		return iNguoiDungRepository.getAllNguoiDungsPage(pageable);
	}

	@Override
	public Page<NguoiDung> findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining(Pageable pageable,
			String hoVaTen, String soDienThoai, String email) {
		return iNguoiDungRepository.findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining(pageable, hoVaTen, soDienThoai, email);
	}

	
}
