package com.fsoft.happflight.entities.chuyen_bay;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fsoft.happflight.entities.dat_cho.Ghe;

@Entity
public class MayBay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_may_bay")
    private Long maMayBay;

    @Column(name = "ten_may_bay", columnDefinition = "nvarchar(50)")
    private String tenMayBay;

    @Column(name = "sl_ghe_pho_thong")
    private Integer SLGhePhoThong;

    @Column(name = "sl_ghe_thuong_gia")
    private Integer SLGheThuongGia;

    @OneToMany(mappedBy = "mayBay", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    Set<ChuyenBay> chuyenBays;

    @OneToMany(mappedBy = "mayBay")
    List<Ghe> ghes;

    public MayBay() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MayBay(Long maMayBay, String tenMayBay, Integer sLGhePhoThong, Integer sLGheThuongGia) {
        super();
        this.maMayBay = maMayBay;
        this.tenMayBay = tenMayBay;
        SLGhePhoThong = sLGhePhoThong;
        SLGheThuongGia = sLGheThuongGia;
    }

    public MayBay(Long maMayBay, String tenMayBay, Integer sLGhePhoThong, Integer sLGheThuongGia,
                  Set<ChuyenBay> chuyenBays, List<Ghe> ghes) {
        super();
        this.maMayBay = maMayBay;
        this.tenMayBay = tenMayBay;
        SLGhePhoThong = sLGhePhoThong;
        SLGheThuongGia = sLGheThuongGia;
        this.chuyenBays = chuyenBays;
        this.ghes = ghes;
    }

    public Long getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(Long maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getTenMayBay() {
        return tenMayBay;
    }

    public void setTenMayBay(String tenMayBay) {
        this.tenMayBay = tenMayBay;
    }

    public Integer getSLGhePhoThong() {
        return SLGhePhoThong;
    }

    public void setSLGhePhoThong(Integer sLGhePhoThong) {
        SLGhePhoThong = sLGhePhoThong;
    }

    public Integer getSLGheThuongGia() {
        return SLGheThuongGia;
    }

    public void setSLGheThuongGia(Integer sLGheThuongGia) {
        SLGheThuongGia = sLGheThuongGia;
    }

    public Set<ChuyenBay> getChuyenBays() {
        return chuyenBays;
    }

    public void setChuyenBays(Set<ChuyenBay> chuyenBays) {
        this.chuyenBays = chuyenBays;
    }

    public List<Ghe> getGhes() {
        return ghes;
    }

    public void setGhes(List<Ghe> ghes) {
        this.ghes = ghes;
    }

    @Override
    public String toString() {
        return "MayBay [maMayBay=" + maMayBay + ", tenMayBay=" + tenMayBay + ", SLGhePhoThong=" + SLGhePhoThong
                + ", SLGheThuongGia=" + SLGheThuongGia + "]";
    }

}