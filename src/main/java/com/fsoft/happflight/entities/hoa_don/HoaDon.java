package com.fsoft.happflight.entities.hoa_don;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

@Entity
public class HoaDon {

    @Id
    @Column(name = "ma_hoa_don", columnDefinition = "nvarchar(50)")
    private String maHoaDon;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "tong_tien")
    private Float tongTien;

    @Column(name = "tt_thanh_toan")
    private Integer trangThaiThanhToan = 0;

    @Column(name = "tt_xoa")
    private Integer trangThaiXoa = 0;

    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private NguoiDung nguoiDung;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    List<VeMayBay> veMayBays;

    public HoaDon() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HoaDon(String maHoaDon, String ngayTao, Float tongTien, Integer trangThaiThanhToan, Integer trangThaiXoa, NguoiDung nguoiDung) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.trangThaiXoa = trangThaiXoa;
        this.nguoiDung = nguoiDung;
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

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
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

    public List<VeMayBay> getVeMayBays() {
        return veMayBays;
    }

    public void setVeMayBays(List<VeMayBay> veMayBays) {
        this.veMayBays = veMayBays;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", tongTien=" + tongTien +
                ", trangThaiThanhToan=" + trangThaiThanhToan +
                ", trangThaiXoa=" + trangThaiXoa +
                ", nguoiDung=" + nguoiDung +
                '}';
    }
}