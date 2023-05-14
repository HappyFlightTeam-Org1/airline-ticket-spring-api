package com.fsoft.happflight.entities.hoa_don;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

import javax.persistence.*;
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
    private NguoiDung user;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<VeMayBay> veMayBays;

    public HoaDon() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HoaDon(String maHoaDon, String ngayTao, Float tongTien, NguoiDung user) {
        super();
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.user = user;
    }

    public HoaDon(String maHoaDon, String ngayTao, Float tongTien, NguoiDung user, Set<VeMayBay> veMayBays) {
        super();
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.user = user;
        this.veMayBays = veMayBays;
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

    public NguoiDung getUser() {
        return user;
    }

    public void setUser(NguoiDung user) {
        this.user = user;
    }

    public Set<VeMayBay> getVeMayBays() {
        return veMayBays;
    }

    public void setVeMayBays(Set<VeMayBay> veMayBays) {
        this.veMayBays = veMayBays;
    }

    @Override
    public String toString() {
        return "HoaDon [maChuyenBay=" + maHoaDon + ", ngayTao=" + ngayTao + ", tongTien=" + tongTien + ", user=" + user
                + "]";
    }

}