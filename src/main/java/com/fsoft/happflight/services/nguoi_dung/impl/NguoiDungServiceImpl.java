package com.fsoft.happflight.services.nguoi_dung.impl;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class NguoiDungServiceImpl implements INguoiDungService {

    @Autowired
    private INguoiDungRepository nguoiDungRepository;


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

	@Override
	public NguoiDung findById(String email) {
		return nguoiDungRepository.findById(email).orElse(null);
	}

}
