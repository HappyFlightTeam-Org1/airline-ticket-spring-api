package com.fsoft.happflight.services.nguoi_dung;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;

public interface INguoiDungService {

	List<NguoiDung> getAllNguoiDungs();
	
	Page<NguoiDung> getAllNguoiDungsPage(Pageable pageable);
	
	Page<NguoiDung>findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining(Pageable pageable, String hoVaTen, String soDienThoai,String email);
}
