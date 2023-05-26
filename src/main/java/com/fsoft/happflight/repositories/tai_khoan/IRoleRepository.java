package com.fsoft.happflight.repositories.tai_khoan;

import com.fsoft.happflight.entities.tai_khoan.Role;
import com.fsoft.happflight.utils.consts.RoleNameConsts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT role_id FROM role WHERE role_name=" + "'" + RoleNameConsts.ROLE_ADMIN + "'", nativeQuery = true)
    int getAdminRoleId();

    @Query(value = "SELECT role_id FROM role WHERE role_name=" + "'" + RoleNameConsts.ROLE_USER + "'", nativeQuery = true)
    int getUserRoleId();

    @Modifying
    @Query(value = "INSERT INTO tai_khoan_role (role_id, ten_tai_khoan) " +
            "VALUES (:roleId, :tenTaiKhoan)", nativeQuery = true)
    void saveTaiKhoanRole(@Param("roleId") long roleId, @Param("tenTaiKhoan") String tenTaiKhoan);
}
