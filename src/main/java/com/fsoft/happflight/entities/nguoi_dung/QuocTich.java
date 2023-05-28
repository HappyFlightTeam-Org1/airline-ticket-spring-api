package com.fsoft.happflight.entities.nguoi_dung;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@Entity
public class QuocTich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_quoc_tich")
    private Long maQuocTich;

    @Column(name = "ten_quoc_tich", columnDefinition = "nvarchar(50)")
    private String tenQuocTich;

    @OneToMany(mappedBy = "quocTich", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    List<NguoiDung> nguoiDungs;

    public QuocTich() {
        super();
        // TODO Auto-generated constructor stub
    }

    public QuocTich(Long maQuocTich, String tenQuocTich) {
        super();
        this.maQuocTich = maQuocTich;
        this.tenQuocTich = tenQuocTich;
    }

    public Long getMaQuocTich() {
        return maQuocTich;
    }

    public void setMaQuocTich(Long maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

    public String getTenQuocTich() {
        return tenQuocTich;
    }

    public void setTenQuocTich(String tenQuocTich) {
        this.tenQuocTich = tenQuocTich;
    }

    public List<NguoiDung> getNguoiDungs() {
        return nguoiDungs;
    }

    public void setNguoiDungs(List<NguoiDung> nguoiDungs) {
        this.nguoiDungs = nguoiDungs;
    }

    @Override
    public String toString() {
        return "QuocTich [maQuocTich=" + maQuocTich + ", tenQuocTich=" + tenQuocTich + "]";
    }

}

