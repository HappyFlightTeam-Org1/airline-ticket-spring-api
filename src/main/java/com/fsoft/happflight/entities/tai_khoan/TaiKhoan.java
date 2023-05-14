package com.fsoft.happflight.entities.tai_khoan;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TaiKhoan {

    @Id
    @Column(name = "ten_tai_khoan", columnDefinition = "nvarchar(50)")
    private String tenTaiKhoan;

    @Column(name = "mat_khau", columnDefinition = "nvarchar(50)")
    private String matKhau;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TaiKhoanRole", joinColumns = @JoinColumn(name = "ten_tai_khoan"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public TaiKhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TaiKhoan(String tenTaiKhoan, String matKhau) {
        super();
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + "]";
    }

}
