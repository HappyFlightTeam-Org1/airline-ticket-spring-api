package com.fsoft.happflight.dto.nguoi_dung;

public class ThayDoiThongTinNguoiDungDTO {
    private String diaChiEmail;

    private String soDienThoai;

    private int quocTich;

    private String gioiTinh;

    private String hoVaTen;

    private String ngaySinh;

    private String hoChieu;

    private String diaChi;

    public ThayDoiThongTinNguoiDungDTO() {}

    public ThayDoiThongTinNguoiDungDTO(String diaChiEmail, String soDienThoai, int quocTich, String gioiTinh, String hoVaTen, String ngaySinh, String hoChieu, String diaChi) {
        this.diaChiEmail = diaChiEmail;
        this.soDienThoai = soDienThoai;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.hoChieu = hoChieu;
        this.diaChi = diaChi;
    }

    public String getDiaChiEmail() {
        return diaChiEmail;
    }

    public void setDiaChiEmail(String diaChiEmail) {
        this.diaChiEmail = diaChiEmail;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(int quocTich) {
        this.quocTich = quocTich;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
