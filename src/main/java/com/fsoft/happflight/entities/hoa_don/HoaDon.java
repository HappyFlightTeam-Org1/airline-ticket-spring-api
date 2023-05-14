package com.fsoft.happflight.entities.hoa_don;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class HoaDon {

    @Id
    @Column(name = "ma_hoa_don", columnDefinition = "nvarchar(50)")
    private String maHoaDon;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "tong_tien")
    private Float tongTien;

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

    public HoaDon(String maHoaDon, String ngayTao, Float tongTien, NguoiDung nguoiDung) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
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
                ", nguoiDung=" + nguoiDung +
                '}';
    }
}