package com.fsoft.happflight.entities.dat_cho;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

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
    Set<Ghe> ghes;

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

    public Set<Ghe> getGhes() {
        return ghes;
    }

    public void setGhes(Set<Ghe> ghes) {
        this.ghes = ghes;
    }

    @Override
    public String toString() {
        return "LoaiGhe [maLoaiGhe=" + maLoaiGhe + ", tenLoaiGhe=" + tenLoaiGhe + "]";
    }

}