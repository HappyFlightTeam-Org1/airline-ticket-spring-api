package com.fsoft.happflight.dto.email;

public class CancelEmailDTO {
    private String emailNguoiDung;
    private String maVe;
    private String hangVe;
    private String giaVe;
    private String tenHanhKhach;
    private String ngayKhoiHanh;
    private String diemDi;
    private String diemDen;

    public CancelEmailDTO() {
    }

    public CancelEmailDTO(String emailNguoiDung, String maVe, String hangVe, String giaVe, String tenHanhKhach, String ngayKhoiHanh, String diemDi, String diemDen) {
        this.emailNguoiDung = emailNguoiDung;
        this.maVe = maVe;
        this.hangVe = hangVe;
        this.giaVe = giaVe;
        this.tenHanhKhach = tenHanhKhach;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
    }

    public String getEmailNguoiDung() {
        return emailNguoiDung;
    }

    public void setEmailNguoiDung(String emailNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
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

    @Override
    public String toString() {
        return "CancelEmailDTO{" +
                "emailNguoiDung='" + emailNguoiDung + '\'' +
                ", maVe='" + maVe + '\'' +
                ", hangVe='" + hangVe + '\'' +
                ", giaVe='" + giaVe + '\'' +
                ", tenHanhKhach='" + tenHanhKhach + '\'' +
                ", ngayKhoiHanh='" + ngayKhoiHanh + '\'' +
                ", diemDi='" + diemDi + '\'' +
                ", diemDen='" + diemDen + '\'' +
                '}';
    }
}
