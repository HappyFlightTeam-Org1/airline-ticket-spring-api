package com.fsoft.happflight.dto.hoa_don;

public class HoaDonDTO {

    private String maHoaDon;
    private String ngayTao;
    private Long tongTien;
    private Integer trangThaiThanhToan = 0;
    private Integer trangThaiXoa = 0;
    private String emailNguoiDung;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String maHoaDon, String ngayTao, Long tongTien, Integer trangThaiThanhToan, Integer trangThaiXoa, String emailNguoiDung) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.trangThaiXoa = trangThaiXoa;
        this.emailNguoiDung = emailNguoiDung;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Long getTongTien() {
        return tongTien;
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(Integer trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getEmailNguoiDung() {
        return emailNguoiDung;
    }

    public void setEmailNguoiDung(String emailNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", tongTien=" + tongTien +
                ", trangThaiThanhToan=" + trangThaiThanhToan +
                ", trangThaiXoa=" + trangThaiXoa +
                ", emailNguoiDung='" + emailNguoiDung + '\'' +
                '}';
    }
}
