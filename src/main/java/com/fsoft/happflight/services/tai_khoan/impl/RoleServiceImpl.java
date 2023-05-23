package com.fsoft.happflight.services.tai_khoan.impl;

import com.fsoft.happflight.repositories.tai_khoan.IRoleRepository;
import com.fsoft.happflight.services.tai_khoan.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public int getAdminRoleId() {
        return roleRepository.getAdminRoleId();
    }

    @Override
    public int getUserRoleId() {
        return roleRepository.getUserRoleId();
    }

    @Override
    public void saveTaiKhoanWithUserRole(String tenTaiKhoan) {
        roleRepository.saveTaiKhoanRole(getUserRoleId(), tenTaiKhoan);
    }
}
