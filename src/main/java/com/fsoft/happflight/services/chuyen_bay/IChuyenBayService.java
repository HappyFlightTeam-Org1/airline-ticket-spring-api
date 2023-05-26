package com.fsoft.happflight.services.chuyen_bay;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

public interface IChuyenBayService {

	void save(ChuyenBay chuyenBay);


	ChuyenBay findById(String maChuyenBay);
	
	Page<ChuyenBay> searchChuyenBay(String diemDi, String diemDen, String ngayKhoiHanh,
	        Direction sortDirection, String sortBy, Pageable pageable);


	Page<ChuyenBay> searchChuyenBayAdmin(String diemDi, String diemDen, String ngayKhoiHanh,
	        Direction sortDirection, String sortBy, Pageable pageable);
	
	List<ChuyenBay> getListMonthNow();

}
