package com.fsoft.happflight.entities.chuyen_bay;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class HangBay {

    @Id
    @Column(name = "ma_hang_bay", columnDefinition = "nvarchar(50)")
    private String maHangBay;

    @Column(name = "ten_hang_bay", columnDefinition = "nvarchar(50)")
    private String tenHangBay;

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

    @Override
    public String toString() {
        return "HangBay [maHangBay=" + maHangBay + ", tenHangBay=" + tenHangBay + "]";
    }

}
