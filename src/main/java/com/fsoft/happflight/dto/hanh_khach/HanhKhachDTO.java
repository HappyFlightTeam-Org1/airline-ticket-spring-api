package com.fsoft.happflight.dto.hanh_khach;

public class HanhKhachDTO {
    private String tenHanhKhach;
    private String ngaySinh;
    private String gioiTinh;
    private String loaiHanhKhach;
    private Integer trangThaiXoa = 0;

    public HanhKhachDTO() {
        super();
    }

    public HanhKhachDTO(String tenHanhKhach, String ngaySinh, String soDienThoai, String gioiTinh, String loaiHanhKhach, String hoChieu, Integer trangThaiXoa) {
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.loaiHanhKhach = loaiHanhKhach;
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public HanhKhachDTO(String tenHanhKhach, String ngaySinh,  String gioiTinh, String loaiHanhKhach) {
        super();
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.loaiHanhKhach = loaiHanhKhach;
    }

 
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    @Override
    public String toString() {
        return "HanhKhachDTO [tenHanhKhach=" + tenHanhKhach  + ", gioiTinh=" + gioiTinh
                + ", loaiHanhKhach=" + loaiHanhKhach  +"]";
    }


}
