package com.fsoft.happflight.entities.hanh_khach;

import javax.persistence.*;

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

    @Column(name = "so_dien_thoai", columnDefinition = "nvarchar(20)")
    private String soDienThoai;

    @Column(name = "gioi_tinh", columnDefinition = "nvarchar(20)")
    private String gioiTinh;

    @Column(name = "ho_chieu", columnDefinition = "nvarchar(20)")
    private String hoChieu;

    @Column(name = "trang_thai_xoa")
    private Integer trangThaiXoa;

    public HanhKhach() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HanhKhach(Long maHanhKhach, String loaiHanhKhach, String tenHanhKhach, String ngaySinh,
                     String soDienThoai, String gioiTinh, String hoChieu, Integer trangThaiXoa) {
        super();
        this.maHanhKhach = maHanhKhach;
        this.loaiHanhKhach = loaiHanhKhach;
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.hoChieu = hoChieu;
        this.trangThaiXoa = trangThaiXoa;
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

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    @Override
    public String toString() {
        return "HanhKhach [maHanhKhach=" + maHanhKhach + ", loaiHanhKhach=" + loaiHanhKhach + ", tenHanhKhach="
                + tenHanhKhach + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh
                + ", hoChieu=" + hoChieu + ", trangThaiXoa=" + trangThaiXoa + "]";
    }

}
