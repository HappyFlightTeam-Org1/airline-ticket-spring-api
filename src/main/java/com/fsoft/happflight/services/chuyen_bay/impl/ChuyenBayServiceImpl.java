package com.fsoft.happflight.services.chuyen_bay.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChuyenBayServiceImpl implements IChuyenBayService {
	@Autowired
	IChuyenBayRepository chuyenBayRepository;

	@Override
	public void save(ChuyenBay chuyenBay) {
		System.out.println("REPO");
		System.out.println(chuyenBay.toString());
		// TODO Auto-generated method stub
		chuyenBayRepository.save(chuyenBay);
	}

	@Override
	public List<ChuyenBay> finAll() {
		// TODO Auto-generated method stub
		return chuyenBayRepository.findAll();
	}

//	@Override
//	public void insertChuyenBay(String maChuyenBay, String diemDi, String diemDen, LocalDate ngayKhoiHanh,
//			LocalTime gioKhoiHanh, LocalTime gioHaCanh, String thoiGianBay, String giaVe, String KLHanhLy,
//			String trangThaiVanHanh, Long maMayBay, String maHangBay) {
//		System.out.println("INSERT");
//		chuyenBayRepository.insertChuyenBay(maChuyenBay, diemDi, diemDen, ngayKhoiHanh, gioKhoiHanh, gioHaCanh,
//				thoiGianBay, giaVe, KLHanhLy, trangThaiVanHanh, maMayBay, maHangBay);
//	}

}
