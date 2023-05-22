package com.fsoft.happflight.dto.nguoi_dung;

public class ThayDoiMatKhauDTO {
    private String matKhauHienTai;

    private String matKhauMoi;

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
