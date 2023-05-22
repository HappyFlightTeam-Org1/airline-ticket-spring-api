package com.fsoft.happflight.dto.nguoi_dung;

import javax.validation.constraints.NotBlank;

public class ThayDoiMatKhauDTO {
    @NotBlank(message = "Trường này là bắt buộc")
    private String matKhauHienTai;

    @NotBlank(message = "Trường này là bắt buộc")
    private String matKhauMoi;

    @NotBlank(message = "Trường này là bắt buộc")
    private String xacNhanMatKhauMoi;

    public ThayDoiMatKhauDTO() {}

    public ThayDoiMatKhauDTO(String matKhauHienTai, String matKhauMoi, String xacNhanMatKhauMoi) {
        this.matKhauHienTai = matKhauHienTai;
        this.matKhauMoi = matKhauMoi;
        this.xacNhanMatKhauMoi = xacNhanMatKhauMoi;
    }

    public String getMatKhauHienTai() {
        return matKhauHienTai;
    }

    public void setMatKhauHienTai(String matKhauHienTai) {
        this.matKhauHienTai = matKhauHienTai;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public String getXacNhanMatKhauMoi() {
        return xacNhanMatKhauMoi;
    }

    public void setXacNhanMatKhauMoi(String xacNhanMatKhauMoi) {
        this.xacNhanMatKhauMoi = xacNhanMatKhauMoi;
    }
}
