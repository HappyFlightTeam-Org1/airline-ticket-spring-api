package com.fsoft.happflight.entities.hanh_khach;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

import javax.persistence.*;
import java.util.List;

@Entity
public class HanhKhach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_hanh_khach")
	private Long maHanhKhach;

	@Column(name = "loai_hanh_khach", columnDefinition = "nvarchar(100)")
	private String loaiHanhKhach;

	@Column(name = "ten_hanh_khach", columnDefinition = "nvarchar(100)")
	private String tenHanhKhach;

	@Column(name = "ngay_sinh")
	private String ngaySinh;

	@Column(name = "gioi_tinh", columnDefinition = "nvarchar(20)")
	private String gioiTinh;

	@Column(name = "trang_thai_xoa")
	private Integer trangThaiXoa;

	@OneToMany(mappedBy = "hanhKhach")
	@JsonIgnore
	private List<VeMayBay> veMayBays;

	public HanhKhach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HanhKhach(Long maHanhKhach, String loaiHanhKhach, String tenHanhKhach, String ngaySinh, String gioiTinh,
			Integer trangThaiXoa) {
		this.maHanhKhach = maHanhKhach;
		this.loaiHanhKhach = loaiHanhKhach;
		this.tenHanhKhach = tenHanhKhach;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.trangThaiXoa = trangThaiXoa;
	}

	public HanhKhach(Long maHanhKhach, String loaiHanhKhach, String tenHanhKhach, String ngaySinh, String gioiTinh,
			Integer trangThaiXoa, List<VeMayBay> veMayBays) {
		this.maHanhKhach = maHanhKhach;
		this.loaiHanhKhach = loaiHanhKhach;
		this.tenHanhKhach = tenHanhKhach;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.trangThaiXoa = trangThaiXoa;
		this.veMayBays = veMayBays;
	}

	public Long getMaHanhKhach() {
		return maHanhKhach;
	}

	public void setMaHanhKhach(Long maHanhKhach) {
		this.maHanhKhach = maHanhKhach;
	}

	public String getLoaiHanhKhach() {
		return loaiHanhKhach;
	}

	public void setLoaiHanhKhach(String loaiHanhKhach) {
		this.loaiHanhKhach = loaiHanhKhach;
	}

	public String getTenHanhKhach() {
		return tenHanhKhach;
	}

	public void setTenHanhKhach(String tenHanhKhach) {
		this.tenHanhKhach = tenHanhKhach;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Integer getTrangThaiXoa() {
		return trangThaiXoa;
	}

	public void setTrangThaiXoa(Integer trangThaiXoa) {
		this.trangThaiXoa = trangThaiXoa;
	}

	public List<VeMayBay> getVeMayBays() {
		return veMayBays;
	}

	public void setVeMayBays(List<VeMayBay> veMayBays) {
		this.veMayBays = veMayBays;
	}

	@Override
	public String toString() {
		return "HanhKhach{" + "maHanhKhach=" + maHanhKhach + ", loaiHanhKhach='" + loaiHanhKhach + '\''
				+ ", tenHanhKhach='" + tenHanhKhach + '\'' + ", ngaySinh='" + ngaySinh + '\'' + ", gioiTinh='"
				+ gioiTinh + '\'' + ", trangThaiXoa=" + trangThaiXoa + '}';
	}
}
