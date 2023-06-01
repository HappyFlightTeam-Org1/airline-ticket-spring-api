package com.fsoft.happflight.dto.hanh_khach;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class HanhKhachDTO implements Validator {

    private String tenHanhKhach;

    private String ngaySinh;

    private String gioiTinh;

    private String loaiHanhKhach;

    private Integer trangThaiXoa = 0;

    public HanhKhachDTO() {
        super();
    }

    public HanhKhachDTO(String tenHanhKhach, String ngaySinh, String gioiTinh, String loaiHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getLoaiHanhKhach() {
        return loaiHanhKhach;
    }

    public void setLoaiHanhKhach(String loaiHanhKhach) {
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public Integer getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Integer trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    @Override
    public String toString() {
        return "HanhKhachDTO{" +
                "tenHanhKhach='" + tenHanhKhach + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", loaiHanhKhach='" + loaiHanhKhach + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        HanhKhachDTO hanhKhach = (HanhKhachDTO) target;
        //validate day:
        if (hanhKhach.getLoaiHanhKhach().equals("Người Lớn")) {
            if (!"".equals(hanhKhach.getNgaySinh())) {
                LocalDate date = LocalDate.parse(hanhKhach.getNgaySinh());
                System.out.println("NGAY SINH " + date);
                if ((LocalDate.now().minusYears(18)).isBefore(date)) {
                    errors.rejectValue("ngaySinh", "date.valid", "Tuổi phải lớn hơn 18!");
                }
            }
        } else if (hanhKhach.getLoaiHanhKhach().equals("Trẻ em")) {
            if (!"".equals(hanhKhach.getNgaySinh())) {
                LocalDate date = LocalDate.parse(hanhKhach.getNgaySinh());
                System.out.println("NGAY SINH " + date);
                if ((LocalDate.now().minusYears(12)).isBefore(date)) {
                    errors.rejectValue("ngaySinh", "date.valid", "Tuổi phải lớn hơn 12!");
                }
            }
        } else {
            if (!"".equals(hanhKhach.getNgaySinh())) {
                LocalDate date = LocalDate.parse(hanhKhach.getNgaySinh());
                if ((LocalDate.now().minusYears(5)).isBefore(date)) {
                    errors.rejectValue("ngaySinh", "date.valid", "Tuổi phải lớn hơn 5!");
                }
            }
        }


    }
}
