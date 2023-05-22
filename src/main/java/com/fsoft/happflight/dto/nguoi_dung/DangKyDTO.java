package com.fsoft.happflight.dto.nguoi_dung;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class DangKyDTO {
    @NotBlank(message = "Trường này là bắt buộc")
    private String diaChiEmail;

    @NotBlank(message = "Trường này là bắt buộc")
    private String tenTaiKhoan;

    @NotBlank(message = "Trường này là bắt buộc")
    private String soDienThoai;

    @NotBlank(message = "Trường này là bắt buộc")
    private String matKhau;

    @NotBlank(message = "Trường này là bắt buộc")
    private String gioiTinh;

    @NotBlank(message = "Trường này là bắt buộc")
    private String hoVaTen;

    @NotBlank(message = "Trường này là bắt buộc")
    private String ngaySinh;

    @NotBlank(message = "Trường này là bắt buộc")
    private String hoChieu;

    @NotBlank(message = "Trường này là bắt buộc")
    private String diaChi;

    private int quocTich;

    public DangKyDTO() {
    }

    public DangKyDTO(String diaChiEmail, String tenTaiKhoan, String soDienThoai, String matKhau, String gioiTinh, String hoVaTen, String ngaySinh, String hoChieu, String diaChi, int quocTich) {
        this.diaChiEmail = diaChiEmail;
        this.tenTaiKhoan = tenTaiKhoan;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.hoChieu = hoChieu;
        this.diaChi = diaChi;
        this.quocTich = quocTich;
    }

    public String getDiaChiEmail() {
        return diaChiEmail;
    }

    public void setDiaChiEmail(String diaChiEmail) {
        this.diaChiEmail = diaChiEmail;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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

    public int getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(int quocTich) {
        this.quocTich = quocTich;
    }
}
