package com.fsoft.happflight.entities.dat_cho;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

import java.util.List;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@Entity
public class DatCho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dat_cho")
    private Long maDatCho;

    @Column(name = "trang_thai", columnDefinition = "nvarchar(50) default 'available'")
    private String trangThai;

    @JoinColumn(name = "ma_ghe", referencedColumnName = "ma_ghe")
    @ManyToOne(targetEntity = Ghe.class)
    private Ghe ghe;

    @JoinColumn(name = "ma_chuyen_bay", referencedColumnName = "ma_chuyen_bay")
    @ManyToOne(targetEntity = ChuyenBay.class)
    private ChuyenBay chuyenBay;

    @OneToMany(mappedBy = "datCho")
    @JsonBackReference
    private List<VeMayBay> veMayBays;

    public DatCho() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DatCho(Long maDatCho, String trangThai, Ghe ghe, ChuyenBay chuyenBay) {
        super();
        this.maDatCho = maDatCho;
        this.trangThai = trangThai;
        this.ghe = ghe;
        this.chuyenBay = chuyenBay;
    }

    public DatCho(String trangThai, Ghe ghe, ChuyenBay chuyenBay) {
        this.trangThai = trangThai;
        this.ghe = ghe;
        this.chuyenBay = chuyenBay;
    }

    public DatCho(Long maDatCho, String trangThai, Ghe ghe, ChuyenBay chuyenBay, List<VeMayBay> veMayBays) {
        this.maDatCho = maDatCho;
        this.trangThai = trangThai;
        this.ghe = ghe;
        this.chuyenBay = chuyenBay;
        this.veMayBays = veMayBays;
    }

    public Long getMaDatCho() {
        return maDatCho;
    }

    public void setMaDatCho(Long maDatCho) {
        this.maDatCho = maDatCho;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public void setChuyenBay(ChuyenBay chuyenBay) {
        this.chuyenBay = chuyenBay;
    }

    public List<VeMayBay> getVeMayBays() {
        return veMayBays;
    }

    public void setVeMayBays(List<VeMayBay> veMayBays) {
        this.veMayBays = veMayBays;
    }

    @Override
    public String toString() {
        return "DatCho [maDatCho=" + maDatCho + ", trangThai=" + trangThai + ", ghe=" + ghe + ", chuyenBay=" + chuyenBay
                + "]";
    }

}
