package com.fsoft.happflight.repositories.tai_khoan;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.tai_khoan.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    @Query(value = "FROM TaiKhoan tk WHERE tk.tenTaiKhoan=:tenTaiKhoan " +
            "AND tk.matKhau=:matKhau")
    TaiKhoan getTaiKhoan(@Param("tenTaiKhoan") String tenTaiKhoan,
                         @Param("matKhau") String matKhau);

    @Query(value = "FROM TaiKhoan tk WHERE tk.tenTaiKhoan=:tenTaiKhoan")
    TaiKhoan getTaiKhoanByTenTaiKhoan(@Param("tenTaiKhoan") String tenTaiKhoan);

    @Query(value = "FROM TaiKhoan tk WHERE tk.matKhau=:matKhau")
    TaiKhoan getTaiKhoanByMatKhau(@Param("matKhau") String matKhau);

    @Modifying
    @Query(value = "UPDATE tai_khoan " +
            "SET mat_khau=:matKhauMoi " +
            "WHERE ten_tai_khoan=:tenTaiKhoan", nativeQuery = true)
    void savePasswordChange(@Param("matKhauMoi") String newPassword, @Param("tenTaiKhoan") String username);
}
