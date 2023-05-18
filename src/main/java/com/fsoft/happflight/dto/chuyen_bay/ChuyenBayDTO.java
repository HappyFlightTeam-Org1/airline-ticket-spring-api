package com.fsoft.happflight.dto.chuyen_bay;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public class ChuyenBayDTO {
    private String maChuyenBay;
    private String diemDi;
    private String diemDen;
    private String ngayKhoiHanh;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioKhoiHanh;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioHaCanh;
    private String thoiGianBay;
    private String giaVe;
    private String kLHanhLy;
    private String trangThaiVanHanh;
    private Long maMayBay;
    private String maHangBay;
    private Integer trangThaiXoa = 0;

    public ChuyenBayDTO(String maChuyenBay, String diemDi, String diemDen, String ngayKhoiHanh, LocalTime gioKhoiHanh, LocalTime gioHaCanh, String thoiGianBay, String giaVe, String kLHanhLy, String trangThaiVanHanh, Long maMayBay, String maHangBay, Integer trangThaiXoa) {
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

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
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
        return "ChuyenBayDTO{" +
                "maChuyenBay='" + maChuyenBay + '\'' +
                ", diemDi='" + diemDi + '\'' +
                ", diemDen='" + diemDen + '\'' +
                ", ngayKhoiHanh='" + ngayKhoiHanh + '\'' +
                ", gioKhoiHanh=" + gioKhoiHanh +
                ", gioHaCanh=" + gioHaCanh +
                ", thoiGianBay='" + thoiGianBay + '\'' +
                ", giaVe='" + giaVe + '\'' +
                ", kLHanhLy='" + kLHanhLy + '\'' +
                ", trangThaiVanHanh='" + trangThaiVanHanh + '\'' +
                ", maMayBay=" + maMayBay +
                ", maHangBay='" + maHangBay + '\'' +
                ", trangThaiXoa=" + trangThaiXoa +
                '}';
    }
}
