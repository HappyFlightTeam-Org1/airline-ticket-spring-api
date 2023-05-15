package com.fsoft.happflight.entities.chuyen_bay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SanBay {

    @Id
    @Column(name = "ma_san_bay", columnDefinition = "nvarchar(50)")
    private String maSanBay;

    @Column(name = "ten_san_bay", columnDefinition = "nvarchar(50)")
    private String tenSanBay;

    @Column(name = "thanh_pho", columnDefinition = "nvarchar(50)")
    private String thanhPho;

    @Column(name = "quoc_gia", columnDefinition = "nvarchar(50)")
    private String quocGia;

    public SanBay() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SanBay(String maSanBay, String tenSanBay, String thanhPho, String quocGia) {
        super();
        this.maSanBay = maSanBay;
        this.tenSanBay = tenSanBay;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

    public String getTenSanBay() {
        return tenSanBay;
    }

    public void setTenSanBay(String tenSanBay) {
        this.tenSanBay = tenSanBay;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "SanBay [maSanBay=" + maSanBay + ", tenSanBay=" + tenSanBay + ", thanhPho=" + thanhPho + ", quocGia="
                + quocGia + "]";
    }

}