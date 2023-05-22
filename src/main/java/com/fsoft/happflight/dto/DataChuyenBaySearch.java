package com.fsoft.happflight.dto;

import org.springframework.data.domain.Page;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

public class DataChuyenBaySearch {
	private Page<ChuyenBay> chuyenBay1Chieu;
	private Page<ChuyenBay> chuyenBayKhuHoi;
	
	public DataChuyenBaySearch() {
		super();
	}

	public DataChuyenBaySearch(Page<ChuyenBay> chuyenBay1Chieu, Page<ChuyenBay> chuyenBayKhuHoi) {
		super();
		this.chuyenBay1Chieu = chuyenBay1Chieu;
		this.chuyenBayKhuHoi = chuyenBayKhuHoi;
	}

	public Page<ChuyenBay> getChuyenBay1Chieu() {
		return chuyenBay1Chieu;
	}

	public void setChuyenBay1Chieu(Page<ChuyenBay> chuyenBay1Chieu) {
		this.chuyenBay1Chieu = chuyenBay1Chieu;
	}

	public Page<ChuyenBay> getChuyenBayKhuHoi() {
		return chuyenBayKhuHoi;
	}

	public void setChuyenBayKhuHoi(Page<ChuyenBay> chuyenBayKhuHoi) {
		this.chuyenBayKhuHoi = chuyenBayKhuHoi;
	}
}
