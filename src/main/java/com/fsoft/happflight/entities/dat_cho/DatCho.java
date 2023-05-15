package com.fsoft.happflight.entities.dat_cho;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

import javax.persistence.*;

@Entity
public class DatCho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dat_cho")
    private Long maDatCho;

    @Column(name = "trang_thai", columnDefinition = "nvarchar(50)")
    private String trangThai;

    @JoinColumn(name = "ma_ghe", referencedColumnName = "ma_ghe")
    @ManyToOne(targetEntity = Ghe.class)
    private Ghe ghe;

    @JoinColumn(name = "ma_chuyen_bay", referencedColumnName = "ma_chuyen_bay")
    @ManyToOne(targetEntity = ChuyenBay.class)
    @JsonBackReference
    private ChuyenBay chuyenBay;

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
