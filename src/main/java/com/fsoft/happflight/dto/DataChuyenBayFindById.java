package com.fsoft.happflight.dto;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
//DucNH66 lấy chuyến bay vừa được chọn
public class DataChuyenBayFindById {
	ChuyenBay chuyenBay1;
	ChuyenBay chuyenBay2;
	
	public DataChuyenBayFindById() {
		super();
	}
	public DataChuyenBayFindById(ChuyenBay chuyenBay1, ChuyenBay chuyenBay2) {
		super();
		this.chuyenBay1 = chuyenBay1;
		this.chuyenBay2 = chuyenBay2;
	}
	public ChuyenBay getChuyenBay1() {
		return chuyenBay1;
	}
	public void setChuyenBay1(ChuyenBay chuyenBay1) {
		this.chuyenBay1 = chuyenBay1;
	}
	public ChuyenBay getChuyenBay2() {
		return chuyenBay2;
	}
	public void setChuyenBay2(ChuyenBay chuyenBay2) {
		this.chuyenBay2 = chuyenBay2;
	}
	
	

}
