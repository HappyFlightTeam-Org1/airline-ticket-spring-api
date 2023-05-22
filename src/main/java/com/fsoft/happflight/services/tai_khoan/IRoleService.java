package com.fsoft.happflight.services.tai_khoan;

public interface IRoleService {
    int getAdminRoleId();

    int getUserRoleId();

    void saveTaiKhoanWithUserRole(String tenTaiKhoan);
}
