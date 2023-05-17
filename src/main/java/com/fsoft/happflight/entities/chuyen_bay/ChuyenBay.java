package com.fsoft.happflight.entities.chuyen_bay;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
public class ChuyenBay {

    @Id
    @Column(name = "ma_chuyen_bay", columnDefinition = "nvarchar(50)")
    private String maChuyenBay;

    @Column(name = "diem_di", columnDefinition = "nvarchar(50)")
    private String diemDi;

    @Column(name = "diem_den", columnDefinition = "nvarchar(50)")
    private String diemDen;

    @Column(name = "ngay_khoi_hanh")
    private String ngayKhoiHanh;

    @Column(name = "gio_khoi_hanh")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioKhoiHanh;

    @Column(name = "gio_ha_canh")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioHaCanh;

    @Column(name = "thoi_gian_bay", columnDefinition = "nvarchar(50)")
    private String thoiGianBay;

    @Column(name = "gia_ve", columnDefinition = "nvarchar(50)")
    private String giaVe;

    @Column(name = "kl_hanh_ly", columnDefinition = "nvarchar(50)")
    private String KLHanhLy;

    @Column(name = "trang_hai_van_hanh", columnDefinition = "nvarchar(50)")
    private String trangThaiVanHanh;

    @Column(name = "trang_thai_xoa")
    private Integer trangThaiXoa;

    @JoinColumn(name = "ma_may_bay", referencedColumnName = "ma_may_bay")
    @ManyToOne(targetEntity = MayBay.class)
    private MayBay mayBay;

    @JoinColumn(name = "ma_hang_bay", referencedColumnName = "ma_hang_bay")
    @ManyToOne(targetEntity = HangBay.class)
    private HangBay hangBay;

    @OneToMany(mappedBy = "chuyenBay")
    List<DatCho> datChos;

    public ChuyenBay() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ChuyenBay(String maChuyenBay, String diemDi, String diemDen, String ngayKhoiHanh, LocalTime gioKhoiHanh,
                     LocalTime gioHaCanh, String thoiGianBay, String giaVe, String kLHanhLy, String trangThaiVanHanh,
                     Integer trangThaiXoa, MayBay mayBay, HangBay hangBay) {
        super();
        this.maChuyenBay = maChuyenBay;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioKhoiHanh = gioKhoiHanh;
        this.gioHaCanh = gioHaCanh;
        this.thoiGianBay = thoiGianBay;
        this.giaVe = giaVe;
        KLHanhLy = kLHanhLy;
        this.trangThaiVanHanh = trangThaiVanHanh;
        this.trangThaiXoa = trangThaiXoa;
        this.mayBay = mayBay;
        this.hangBay = hangBay;
    }

    public ChuyenBay(String maChuyenBay, String diemDi, String diemDen, String ngayKhoiHanh, LocalTime gioKhoiHanh,
                     LocalTime gioHaCanh, String thoiGianBay, String giaVe, String kLHanhLy, String trangThaiVanHanh,
                     Integer trangThaiXoa, MayBay mayBay, HangBay hangBay, List<DatCho> datChos) {
        super();
        this.maChuyenBay = maChuyenBay;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioKhoiHanh = gioKhoiHanh;
        this.gioHaCanh = gioHaCanh;
        this.thoiGianBay = thoiGianBay;
        this.giaVe = giaVe;
        KLHanhLy = kLHanhLy;
        this.trangThaiVanHanh = trangThaiVanHanh;
        this.trangThaiXoa = trangThaiXoa;
        this.mayBay = mayBay;
        this.hangBay = hangBay;
        this.datChos = datChos;
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

    public String getKLHanhLy() {
        return KLHanhLy;
    }

    public void setKLHanhLy(String kLHanhLy) {
        KLHanhLy = kLHanhLy;
    }

    public String getTrangThaiVanHanh() {
        return trangThaiVanHanh;
    }

    public void setTrangThaiVanHanh(String trangThaiVanHanh) {
        this.trangThaiVanHanh = trangThaiVanHanh;
    }

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public HangBay getHangBay() {
        return hangBay;
    }

    public void setHangBay(HangBay hangBay) {
        this.hangBay = hangBay;
    }

    public List<DatCho> getDatChos() {
        return datChos;
    }

    public void setDatChos(List<DatCho> datChos) {
        this.datChos = datChos;
    }

    @Override
    public String toString() {
        return "ChuyenBay [maChuyenBay=" + maChuyenBay + ", diemDi=" + diemDi + ", diemDen=" + diemDen
                + ", ngayKhoiHanh=" + ngayKhoiHanh + ", gioKhoiHanh=" + gioKhoiHanh + ", gioHaCanh=" + gioHaCanh
                + ", thoiGianBay=" + thoiGianBay + ", giaVe=" + giaVe + ", KLHanhLy=" + KLHanhLy + ", trangThaiVanHanh="
                + trangThaiVanHanh + ", trangThaiXoa=" + trangThaiXoa + ", mayBay=" + mayBay + ", hangBay=" + hangBay
                + "]";
    }
}