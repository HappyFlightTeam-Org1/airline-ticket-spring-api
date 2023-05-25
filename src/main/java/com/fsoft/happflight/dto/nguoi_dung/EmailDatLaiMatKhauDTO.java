package com.fsoft.happflight.dto.nguoi_dung;

import com.fsoft.happflight.utils.consts.RegexPatterns;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmailDatLaiMatKhauDTO {
    @NotBlank(message = "Trường này là bắt buộc")
    @Pattern(regexp = RegexPatterns.EMAIL_PATTERN, message = "Định dạng email không hợp lệ")
    private String email;

    public EmailDatLaiMatKhauDTO() {}

    public EmailDatLaiMatKhauDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
