package com.fsoft.happflight.entities.dat_cho;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LoaiGhe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_ghe")
    private Long maLoaiGhe;

    @Column(name = "ten_loai_ghe", columnDefinition = "nvarchar(50)")
    private String tenLoaiGhe;

    @OneToMany(mappedBy = "loaiGhe")
    @JsonBackReference
    List<Ghe> ghes;

    public LoaiGhe(Long maLoaiGhe, String tenLoaiGhe) {
        super();
        this.maLoaiGhe = maLoaiGhe;
        this.tenLoaiGhe = tenLoaiGhe;
    }

    public LoaiGhe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getMaLoaiGhe() {
        return maLoaiGhe;
    }

    public void setMaLoaiGhe(Long maLoaiGhe) {
        this.maLoaiGhe = maLoaiGhe;
    }

    public String getTenLoaiGhe() {
        return tenLoaiGhe;
    }

    public void setTenLoaiGhe(String tenLoaiGhe) {
        this.tenLoaiGhe = tenLoaiGhe;
    }

    public List<Ghe> getGhes() {
        return ghes;
    }

    public void setGhes(List<Ghe> ghes) {
        this.ghes = ghes;
    }

    @Override
    public String toString() {
        return "LoaiGhe [maLoaiGhe=" + maLoaiGhe + ", tenLoaiGhe=" + tenLoaiGhe + "]";
    }

}