package com.fsoft.happflight.entities.ve_ma_bay;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;

import javax.persistence.*;

@Entity
public class VeMayBay {

    @Id
    @Column(name = "ma_ve")
    private String maVe;

    @Column(name = "hang_ve", columnDefinition = "nvarchar(50)")
    private String hangVe;

    @Column(name = "gia_ve")
    private Long giaVe;

    @Column(name = "trang_thai_xoa")
    private Integer trangThaiXoa;

    @OneToOne
    @JoinColumn(name = "ma_hanh_khach", referencedColumnName = "ma_hanh_khach")
    private HanhKhach hanhKhach;

    @OneToOne
    @JoinColumn(name = "ma_dat_cho", referencedColumnName = "ma_dat_cho")
    private DatCho datCho;

    @JoinColumn(name = "ma_hoa_don", referencedColumnName = "ma_hoa_don")
    @ManyToOne
    private HoaDon hoaDon;

    public VeMayBay() {
        super();
        // TODO Auto-generated constructor stub
    }

    public VeMayBay(String maVe, String hangVe, Long giaVe, Integer trangThaiXoa) {
        this.maVe = maVe;
        this.hangVe = hangVe;
        this.giaVe = giaVe;
        this.trangThaiXoa = trangThaiXoa;
    }

    public VeMayBay(String maVe, String hangVe, Long giaVe, Integer trangThaiXoa, HanhKhach hanhKhach, DatCho datCho, HoaDon hoaDon) {
        this.maVe = maVe;
        this.hangVe = hangVe;
        this.giaVe = giaVe;
        this.trangThaiXoa = trangThaiXoa;
        this.hanhKhach = hanhKhach;
        this.datCho = datCho;
        this.hoaDon = hoaDon;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getHangVe() {
        return hangVe;
    }

    public void setHangVe(String hangVe) {
        this.hangVe = hangVe;
    }

    public Long getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(Long giaVe) {
        this.giaVe = giaVe;
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
        return "VeMayBay{" +
                "maVe='" + maVe + '\'' +
                ", hangVe='" + hangVe + '\'' +
                ", giaVe=" + giaVe +
                ", trangThaiXoa=" + trangThaiXoa +
                ", hanhKhach=" + hanhKhach +
                ", datCho=" + datCho +
                ", hoaDon=" + hoaDon +
                '}';
    }
}
