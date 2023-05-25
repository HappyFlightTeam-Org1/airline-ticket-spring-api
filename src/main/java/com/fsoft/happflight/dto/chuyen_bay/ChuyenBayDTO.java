package com.fsoft.happflight.dto.chuyen_bay;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fsoft.happflight.utils.CheckMaChuyenBay;

public class ChuyenBayDTO implements Validator {
	@CheckMaChuyenBay
	@NotBlank(message = " không được để trống!")
	private String maChuyenBay;
	@NotBlank(message =  " không được để trống!")
	private String diemDi;
	@NotBlank(message =  " không được để trống!")
	private String diemDen;
	private String ngayKhoiHanh;
	@NotNull(message = " không được để trống")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioKhoiHanh;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioHaCanh;
	private String thoiGianBay;
	private Long giaVe;
	@NotBlank(message =  " không được để trống!")
	private String kLHanhLy;
	@NotBlank(message =  " không được để trống!")
	private String trangThaiVanHanh;
	@NotNull(message = " không được để trống")
	private Long maMayBay;
	@NotBlank(message =  " không được để trống!")
	private String maHangBay;
	private Integer trangThaiXoa = 0;

	public ChuyenBayDTO(String maChuyenBay, String diemDi, String diemDen, String ngayKhoiHanh, LocalTime gioKhoiHanh,
			LocalTime gioHaCanh, String thoiGianBay, Long giaVe, String kLHanhLy, String trangThaiVanHanh,
			Long maMayBay, String maHangBay, Integer trangThaiXoa) {
		this.maChuyenBay = maChuyenBay;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.gioKhoiHanh = gioKhoiHanh;
		this.gioHaCanh = gioHaCanh;
		this.thoiGianBay = thoiGianBay;
		this.giaVe = giaVe;
		this.kLHanhLy = kLHanhLy;
		this.trangThaiVanHanh = trangThaiVanHanh;
		this.maMayBay = maMayBay;
		this.maHangBay = maHangBay;
		this.trangThaiXoa = trangThaiXoa;
	}

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public String getDiemDi() {
		return diemDi;
	}

	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}

	public String getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}

	public void setNgayKhoiHanh(String ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}

	public LocalTime getGioKhoiHanh() {
		return gioKhoiHanh;
	}

	public void setGioKhoiHanh(LocalTime gioKhoiHanh) {
		this.gioKhoiHanh = gioKhoiHanh;
	}

	public LocalTime getGioHaCanh() {
		return gioHaCanh;
	}

	public void setGioHaCanh(LocalTime gioHaCanh) {
		this.gioHaCanh = gioHaCanh;
	}

	public String getThoiGianBay() {
		return thoiGianBay;
	}

	public void setThoiGianBay(String thoiGianBay) {
		this.thoiGianBay = thoiGianBay;
	}

	public Long getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(Long giaVe) {
		this.giaVe = giaVe;
	}

	public String getkLHanhLy() {
		return kLHanhLy;
	}

	public void setkLHanhLy(String kLHanhLy) {
		this.kLHanhLy = kLHanhLy;
	}

	public String getTrangThaiVanHanh() {
		return trangThaiVanHanh;
	}

	public void setTrangThaiVanHanh(String trangThaiVanHanh) {
		this.trangThaiVanHanh = trangThaiVanHanh;
	}

	public Long getMaMayBay() {
		return maMayBay;
	}

	public void setMaMayBay(Long maMayBay) {
		this.maMayBay = maMayBay;
	}

	public String getMaHangBay() {
		return maHangBay;
	}

	public void setMaHangBay(String maHangBay) {
		this.maHangBay = maHangBay;
	}

	public Integer getTrangThaiXoa() {
		return trangThaiXoa;
	}

	public void setTrangThaiXoa(Integer trangThaiXoa) {
		this.trangThaiXoa = trangThaiXoa;
	}

	@Override
	public String toString() {
		return "ChuyenBayDTO{" + "maChuyenBay='" + maChuyenBay + '\'' + ", diemDi='" + diemDi + '\'' + ", diemDen='"
				+ diemDen + '\'' + ", ngayKhoiHanh='" + ngayKhoiHanh + '\'' + ", gioKhoiHanh=" + gioKhoiHanh
				+ ", gioHaCanh=" + gioHaCanh + ", thoiGianBay='" + thoiGianBay + '\'' + ", giaVe='" + giaVe + '\''
				+ ", kLHanhLy='" + kLHanhLy + '\'' + ", trangThaiVanHanh='" + trangThaiVanHanh + '\'' + ", maMayBay="
				+ maMayBay + ", maHangBay='" + maHangBay + '\'' + ", trangThaiXoa=" + trangThaiXoa + '}';
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChuyenBayDTO chuyenBayDTO = (ChuyenBayDTO) target;
	
		if (!chuyenBayDTO.getMaChuyenBay().matches("^CB\\d{3}$")) {
	        errors.rejectValue("maChuyenBay", "", " nhập đúng định dạng CBxxx với x là số nguyên dương!");
	    }
	
		
		if (chuyenBayDTO.getNgayKhoiHanh() == null || chuyenBayDTO.getNgayKhoiHanh() == "") {
			errors.rejectValue("ngayKhoiHanh", "", " không được để trống!");
		} else {
			LocalDate currentDate = LocalDate.now();
			LocalDate ngayKhoiHanh=LocalDate.parse(chuyenBayDTO.getNgayKhoiHanh());
			LocalDate conditionDate=currentDate.plusDays(7);
			if(ngayKhoiHanh.isBefore(conditionDate)) {
				errors.rejectValue("ngayKhoiHanh", "", " phải cách ngày hiện tại ít nhất 7 ngày!");
			}
		}
		
	
		if (chuyenBayDTO.getGioHaCanh() == null ) {
		    errors.rejectValue("gioHaCanh", "", " không được để trống!");
		} 
//		else {
//		    LocalTime gioKhoiHanh = chuyenBayDTO.getGioKhoiHanh();
//		    LocalTime gioHaCanh = chuyenBayDTO.getGioHaCanh();
//		    LocalTime conditionTime=gioKhoiHanh.plusHours(0);
//		    if (gioHaCanh.isBefore(conditionTime)) {
//		        errors.rejectValue("gioHaCanh", "", " phải lớn hơn giờ khởi hành ít nhất 1h!");
//		    }
		
		
		if(chuyenBayDTO.getGiaVe()==null) {
			errors.rejectValue("giaVe", "", " không được để trống!");
			
		
		}else if (chuyenBayDTO.getGiaVe()<0 ) {
			errors.rejectValue("giaVe", "", " không được nhỏ hơn 0!");
		}

	}
	
}
