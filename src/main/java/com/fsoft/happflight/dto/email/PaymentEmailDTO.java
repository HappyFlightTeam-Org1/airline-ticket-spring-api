package com.fsoft.happflight.dto.email;

public class PaymentEmailDTO {
    private String emailNguoiDung;
    private String maHoaDon;
    private String tongTien;
    private String ngayThanhToan;
    private String tenNguoiDung;

    public PaymentEmailDTO() {
    }

    public PaymentEmailDTO(String emailNguoiDung, String maHoaDon, String tongTien, String ngayThanhToan, String tenNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
        this.maHoaDon = maHoaDon;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmailNguoiDung() {
        return emailNguoiDung;
    }

    public void setEmailNguoiDung(String emailNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
}


