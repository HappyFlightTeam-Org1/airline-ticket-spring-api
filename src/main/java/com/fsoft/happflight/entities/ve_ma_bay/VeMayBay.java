package com.fsoft.happflight.entities.ve_ma_bay;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;

import javax.persistence.*;

@Entity
public class VeMayBay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ve")
    private Long maVe;

    @Column(name = "hang_ve", columnDefinition = "nvarchar(50)")
    private String hangVe;

    @Column(name = "trang_thai_xoa")
    private Integer trangThaiXoa;

    @JoinColumn(name = "ma_hanh_khach", referencedColumnName = "ma_hanh_khach")
    @OneToOne(fetch = FetchType.LAZY)
    private HanhKhach hanhKhach;

    @JoinColumn(name = "ma_dat_cho", referencedColumnName = "ma_dat_cho")
    @OneToOne(fetch = FetchType.LAZY)
    private DatCho datCho;

    @JoinColumn(name = "ma_hoa_don", referencedColumnName = "ma_hoa_don")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private HoaDon hoaDon;

    public VeMayBay() {
        super();
        // TODO Auto-generated constructor stub
    }

    public VeMayBay(Long maVe, String hangVe, Integer trangThaiXoa, HanhKhach hanhKhach, DatCho datCho, HoaDon hoaDon) {
        super();
        this.maVe = maVe;
        this.hangVe = hangVe;
        this.trangThaiXoa = trangThaiXoa;
        this.hanhKhach = hanhKhach;
        this.datCho = datCho;
        this.hoaDon = hoaDon;
    }

    public Long getMaVe() {
        return maVe;
    }

    public void setMaVe(Long maVe) {
        this.maVe = maVe;
    }

    public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public HanhKhach getHanhKhach() {
        return hanhKhach;
    }

    public void setHanhKhach(HanhKhach hanhKhach) {
        this.hanhKhach = hanhKhach;
    }

    public DatCho getDatCho() {
        return datCho;
    }

    public void setDatCho(DatCho datCho) {
        this.datCho = datCho;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public String toString() {
        return "VeMayBay [maVe=" + maVe + ", hangVe=" + hangVe + ", trangThaiXoa=" + trangThaiXoa + ", hanhKhach="
                + hanhKhach + ", datCho=" + datCho + ", hoaDon=" + hoaDon + "]";
    }

}
