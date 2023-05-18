package com.fsoft.happflight.services.chuyen_bay;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

public interface IChuyenBayService {

	void save(ChuyenBay chuyenBay);

	List<ChuyenBay> finAll();

	ChuyenBay findById(String maChuyenBay);

	Page<ChuyenBay> searchChuyenBay(String diemDi, String diemDen, String ngayKhoiHanh,
			Sort.Direction sortDirection, String sortBy, Pageable pageable);

}
