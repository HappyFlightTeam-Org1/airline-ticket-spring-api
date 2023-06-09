package com.fsoft.happflight.entities.chuyen_bay;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@Entity
public class HangBay {

    @Id
    @Column(name = "ma_hang_bay", columnDefinition = "nvarchar(50)")
    private String maHangBay;

    @Column(name = "ten_hang_bay", columnDefinition = "nvarchar(50)")
    private String tenHangBay;

    @Column(name = "logo_url", columnDefinition = "nvarchar(250)")
    private String logoURL;

    @OneToMany(mappedBy = "hangBay", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    List<ChuyenBay> chuyenBays;

    public HangBay() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HangBay(String maHangBay, String tenHangBay) {
        super();
        this.maHangBay = maHangBay;
        this.tenHangBay = tenHangBay;
    }

    public HangBay(String maHangBay, String tenHangBay, String logoURL) {
        this.maHangBay = maHangBay;
        this.tenHangBay = tenHangBay;
        this.logoURL = logoURL;
    }

    public HangBay(String maHangBay, String tenHangBay, List<ChuyenBay> chuyenBays) {
        super();
        this.maHangBay = maHangBay;
        this.tenHangBay = tenHangBay;
        this.chuyenBays = chuyenBays;
    }

    public String getMaHangBay() {
        return maHangBay;
    }

    public void setMaHangBay(String maHangBay) {
        this.maHangBay = maHangBay;
    }

    public String getTenHangBay() {
        return tenHangBay;
    }

    public void setTenHangBay(String tenHangBay) {
        this.tenHangBay = tenHangBay;
    }

    public List<ChuyenBay> getChuyenBays() {
        return chuyenBays;
    }

    public void setChuyenBays(List<ChuyenBay> chuyenBays) {
        this.chuyenBays = chuyenBays;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    @Override
    public String toString() {
        return "HangBay [maHangBay=" + maHangBay + ", tenHangBay=" + tenHangBay + "]";
    }

}
