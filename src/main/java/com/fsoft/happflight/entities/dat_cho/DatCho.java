package com.fsoft.happflight.entities.dat_cho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

@Entity
public class DatCho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dat_cho")
    private Long maDatCho;

    @Column(name = "trang_thai", columnDefinition = "nvarchar(50)")
    private String trangThai = "available";

    @JoinColumn(name = "ma_ghe", referencedColumnName = "ma_ghe")
    @ManyToOne(targetEntity = Ghe.class)
    private Ghe ghe;

    @JoinColumn(name = "ma_chuyen_bay", referencedColumnName = "ma_chuyen_bay")
    @ManyToOne(targetEntity = ChuyenBay.class)
    private ChuyenBay chuyenBay;

    @OneToOne(mappedBy = "datCho")
    @JsonIgnore
    private VeMayBay veMayBay;

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

    @Override
    public String toString() {
        return "DatCho [maDatCho=" + maDatCho + ", trangThai=" + trangThai + ", ghe=" + ghe + ", chuyenBay=" + chuyenBay
                + "]";
    }

}
