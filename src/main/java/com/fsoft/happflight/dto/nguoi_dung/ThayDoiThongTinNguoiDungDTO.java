package com.fsoft.happflight.dto.nguoi_dung;

import com.fsoft.happflight.utils.consts.RegexPatterns;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ThayDoiThongTinNguoiDungDTO {
    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.EMAIL_PATTERN, message = "Định dạng email không hợp lệ")
    private String diaChiEmail;

    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.SO_DIEN_THOAI_PATTERN, message = "Định dạng số điện thoại không hợp lệ")
    private String soDienThoai;

    @NotNull(message = "Trường này là bắt buộc")
    private int quocTich;

    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.GIOI_TINH_PATTERN, message = "Định dạng giới tính không hợp lệ")
    private String gioiTinh;

    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.HO_TEN_PATTERN, message = "Định dạng họ tên không hợp lệ")
    private String hoVaTen;

    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.NGAY_SINH_PATTERN, message = "Định dạng ngày sinh không hợp lệ")
    private String ngaySinh;

    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.HO_CHIEU_PATTERN, message = "Định dạng hộ chiếu không hợp lệ")
    private String hoChieu;

    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.DIA_CHI_PATTERN, message = "Định dạng địa chỉ không hơợp lệ")
    private String diaChi;

    public ThayDoiThongTinNguoiDungDTO() {}

    public ThayDoiThongTinNguoiDungDTO(String diaChiEmail, String soDienThoai, int quocTich, String gioiTinh, String hoVaTen, String ngaySinh, String hoChieu, String diaChi) {
        this.diaChiEmail = diaChiEmail;
        this.soDienThoai = soDienThoai;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.hoChieu = hoChieu;
        this.diaChi = diaChi;
    }

    public String getDiaChiEmail() {
        return diaChiEmail;
    }

    public void setDiaChiEmail(String diaChiEmail) {
        this.diaChiEmail = diaChiEmail;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(int quocTich) {
        this.quocTich = quocTich;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getHoChieu() {
        return hoChieu;
    }

    public void setHoChieu(String hoChieu) {
        this.hoChieu = hoChieu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
