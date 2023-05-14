package com.fsoft.happflight.dto.hanh_khach;

public class HanhKhachDTO {
    private String tenHanhKhach;
    private String ngaySinh;
    private String soDienThoai;
    private String gioiTinh;
    private String loaiHanhKhach;
    private String hoChieu;
    private Integer trangThaiXoa = 0;

    public HanhKhachDTO() {
        super();
    }

    public HanhKhachDTO(String tenHanhKhach, String ngaySinh, String soDienThoai, String gioiTinh, String loaiHanhKhach, String hoChieu, Integer trangThaiXoa) {
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.loaiHanhKhach = loaiHanhKhach;
        this.hoChieu = hoChieu;
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public HanhKhachDTO(String tenHanhKhach, String ngaySinh, String soDienThoai, String gioiTinh, String loaiHanhKhach,
                        String hoChieu) {
        super();
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.loaiHanhKhach = loaiHanhKhach;
        this.hoChieu = hoChieu;
    }

//	public LocalDate getNgaySinh() {
//		return ngaySinh;
//	}
//
//	public void setNgaySinh(LocalDate ngaySinh) {
//		this.ngaySinh = ngaySinh;
//	}

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
    }

    public String getLoaiHanhKhach() {
        return loaiHanhKhach;
    }

    public void setLoaiHanhKhach(String loaiHanhKhach) {
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "HanhKhachDTO [tenHanhKhach=" + tenHanhKhach + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh
                + ", loaiHanhKhach=" + loaiHanhKhach + ", hoChieu=" + hoChieu + "]";
    }

//	@Override
//	public String toString() {
//		return "HanhKhachDTO [tenHanhKhach=" + tenHanhKhach + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai
//				+ ", gioiTinh=" + gioiTinh + ", loaiHanhKhach=" + loaiHanhKhach + ", hoChieu=" + hoChieu + "]";
//	}

}
