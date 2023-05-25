package com.fsoft.happflight.dto.nguoi_dung;

import javax.validation.constraints.NotBlank;

public class DatLaiMatKhauDTO {
    @NotBlank(message = "Trường này là bắt buộc")
    private String resetToken;

    @NotBlank(message = "Trường này là bắt buộc")
    private String matKhauMoi;

    @NotBlank(message = "Trường này là bắt buộc")
    private String datLaiMatKhauMoi;

    public DatLaiMatKhauDTO() {}

    public DatLaiMatKhauDTO(String resetToken, String matKhauMoi, String datLaiMatKhauMoi) {
        this.resetToken = resetToken;
        this.matKhauMoi = matKhauMoi;
        this.datLaiMatKhauMoi = datLaiMatKhauMoi;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public String getDatLaiMatKhauMoi() {
        return datLaiMatKhauMoi;
    }

    public void setDatLaiMatKhauMoi(String datLaiMatKhauMoi) {
        this.datLaiMatKhauMoi = datLaiMatKhauMoi;
    }
}
