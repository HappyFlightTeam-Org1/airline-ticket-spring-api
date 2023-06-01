package com.fsoft.happflight.repositories.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Contains CRUD method use for nguoi_dung table
 */
@Repository
@Transactional
public interface INguoiDungAuthenRepository extends JpaRepository<NguoiDung, String> {
    /**
     * Query 1 NguoiDung from database matches email
     * @param email String of email
     * @return NguoiDung object
     */
    @Query(value = "SELECT * FROM nguoi_dung WHERE email=:email", nativeQuery = true)
    NguoiDung getNguoiDungByEmail(@Param("email") String email);

    /**
     * Query 1 NguoiDung from database matches ten_tai_khoan
     * @param tenTaiKhoan String of ten_tai_khoan
     * @return NguoiDung object
     */
    @Query(value = "SELECT * FROM nguoi_dung WHERE ten_tai_khoan=:ten_tai_khoan", nativeQuery = true)
    NguoiDung getNguoiDungByUsername(@Param("ten_tai_khoan") String tenTaiKhoan);

    /**
     * Save edited NguoiDung info to database
     * @param email String of email
     * @param soDienThoai String of soDienThoai
     * @param ngaySinh String of ngaySinh
     * @param diaChi String of diaChi
     * @param hoChieu String of hoChieu
     * @param gioiTinh String of gioiTinh
     * @param quocTich int of quocTich
     * @param tenTaiKhoan String of tenTaiKhoan
     */
    @Modifying
    @Query(value = "UPDATE nguoi_dung SET " +
            "email=:email, " +
            "so_dien_thoai=:so_dien_thoai, " +
            "ngay_sinh=:ngay_sinh, " +
            "dia_chi=:dia_chi, " +
            "ho_chieu=:ho_chieu, " +
            "gioi_tinh=:gioi_tinh, " +
            "ma_quoc_tich=:ma_quoc_tich " +
            "WHERE ten_tai_khoan=:ten_tai_khoan", nativeQuery = true)
    void saveNguoiDung(@Param("email") String email,
                       @Param("so_dien_thoai") String soDienThoai,
                       @Param("ngay_sinh") String ngaySinh,
                       @Param("dia_chi") String diaChi,
                       @Param("ho_chieu") String hoChieu,
                       @Param("gioi_tinh") String gioiTinh,
                       @Param("ma_quoc_tich") int quocTich,
                       @Param("ten_tai_khoan") String tenTaiKhoan);

    /**
     * Set nguoi_dung deleted state to 1 (deleted) with match email
     * @param email email cua nguoi_dung
     */
    @Modifying
    @Query(value = "UPDATE nguoi_dung " +
            "SET trang_thai_xoa = 1 " +
            "WHERE email = :email", nativeQuery = true)
    void deleteNguoiDung(@Param("email") String email);

    /**
     * Set nguoi_dung deleted state to 0 (not deleted) with match email
     * @param email email cua nguoi_dung
     */
    @Modifying
    @Query(value = "UPDATE nguoi_dung " +
            "SET trang_thai_xoa = 0 " +
            "WHERE email = :email", nativeQuery = true)
    void removeDeleteNguoiDung(@Param("email") String email);
}
