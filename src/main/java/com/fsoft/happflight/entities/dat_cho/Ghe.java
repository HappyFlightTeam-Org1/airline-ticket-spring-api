package com.fsoft.happflight.entities.dat_cho;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Ghe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ghe")
    private Long maGhe;

    @Column(name = "ten_ghe", columnDefinition = "nvarchar(50)")
    private String tenGhe;

    @JoinColumn(name = "ma_may_bay", referencedColumnName = "ma_may_bay")
    @ManyToOne(targetEntity = MayBay.class)
    @JsonBackReference
    private MayBay mayBay;

    @JoinColumn(name = "ma_loai_ghe", referencedColumnName = "ma_loai_ghe")
    @ManyToOne(targetEntity = LoaiGhe.class)
    private LoaiGhe loaiGhe;

    @OneToMany(mappedBy = "ghe")
    @JsonBackReference
    List<DatCho> datChos;

    public Ghe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Ghe(Long maGhe, String tenGhe, MayBay mayBay, LoaiGhe loaiGhe) {
        super();
        this.maGhe = maGhe;
        this.tenGhe = tenGhe;
        this.mayBay = mayBay;
        this.loaiGhe = loaiGhe;
    }

    public Long getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(Long maGhe) {
        this.maGhe = maGhe;
    }

    public String getTenGhe() {
        return tenGhe;
    }

    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public LoaiGhe getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(LoaiGhe loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public List<DatCho> getDatChos() {
        return datChos;
    }

    public void setDatChos(List<DatCho> datChos) {
        this.datChos = datChos;
    }

    @Override
    public String toString() {
        return "Ghe [maGhe=" + maGhe + ", tenGhe=" + tenGhe + ", mayBay=" + mayBay + "]";
    }

}