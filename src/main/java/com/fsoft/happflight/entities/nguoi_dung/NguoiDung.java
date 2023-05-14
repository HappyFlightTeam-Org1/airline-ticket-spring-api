package com.fsoft.happflight.entities.nguoi_dung;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fsoft.happflight.entities.dat_cho.Ghe;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.tai_khoan.TaiKhoan;

import javax.persistence.*;
import java.util.List;

@Entity
public class NguoiDung {

    @Id
    @Column(name = "email", columnDefinition = "nvarchar(50)")
    private String email;

    @Column(name = "so_dien_thoai", columnDefinition = "nvarchar(20)")
    private String soDienThoai;

    @Column(name = "ho_va_ten", columnDefinition = "nvarchar(50)")
    private String hoVaTen;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "dia_chi", columnDefinition = "nvarchar(255)")
    private String diaChi;

    @Column(name = "ho_chieu", columnDefinition = "nvarchar(20)")
    private String hoChieu;

    @Column(name = "gioi_tinh", columnDefinition = "nvarchar(20)")
    private String gioiTinh;

    @JoinColumn(name = "ma_quoc_tich", referencedColumnName = "ma_quoc_tich")
    @ManyToOne(fetch = FetchType.LAZY)
    private QuocTich quocTich;

    @JoinColumn(name = "ten_tai_khoan", referencedColumnName = "ten_tai_khoan")
    @OneToOne(fetch = FetchType.LAZY)
    private TaiKhoan taiKhoan;

    @Column(name = "trang_thai_xoa")
    private Integer trangThaiXoa;

    @OneToMany(mappedBy = "nguoiDung")
    @JsonManagedReference
    List<HoaDon> hoaDons;

    public NguoiDung() {
        super();
        // TODO Auto-generated constructor stub
    }

    public NguoiDung(String email, String soDienThoai, String hoVaTen, String ngaySinh, String diaChi,
                     String hoChieu, String gioiTinh, QuocTich quocTich, TaiKhoan taiKhoan, Integer trangThaiXoa) {
        super();
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.hoChieu = hoChieu;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.taiKhoan = taiKhoan;
        this.trangThaiXoa = trangThaiXoa;
    }

    public NguoiDung(String email, String soDienThoai, String hoVaTen, String ngaySinh, String diaChi,
                     String hoChieu, String gioiTinh, QuocTich quocTich, Integer trangThaiXoa) {
        super();
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.hoChieu = hoChieu;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public QuocTich getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(QuocTich quocTich) {
        this.quocTich = quocTich;
    }

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    @Override
    public String toString() {
        return "NguoiDung [email=" + email + ", soDienThoai=" + soDienThoai + ", hoVaTen=" + hoVaTen + ", ngaySinh="
                + ngaySinh + ", diaChi=" + diaChi + ", hoChieu=" + hoChieu + ", gioiTinh=" + gioiTinh + ", quocTich="
                + quocTich + ", taiKhoan=" + taiKhoan + ", trangThaiXoa=" + trangThaiXoa + "]";
    }

}