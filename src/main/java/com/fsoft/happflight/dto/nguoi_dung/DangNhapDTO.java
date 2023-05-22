package com.fsoft.happflight.dto.nguoi_dung;

import javax.validation.constraints.NotBlank;

public class DangNhapDTO {
    @NotBlank(message = "Trường này là bắt buộc")
    private String tenTaiKhoan;

    @NotBlank(message = "Trường này là bắt buôc")
    private String matKhau;

    public DangNhapDTO() { }

    public DangNhapDTO(String tenTaiKhoan, String matKhau) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
