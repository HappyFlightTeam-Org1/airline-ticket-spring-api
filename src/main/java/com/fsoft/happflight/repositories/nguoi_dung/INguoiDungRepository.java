package com.fsoft.happflight.repositories.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface INguoiDungRepository extends JpaRepository<NguoiDung, String> {

	/*
	 * @Param getAllNguoiDungs
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list nguoi dung)
	 */
	@Query(value = "select * from nguoi_dung where ten_tai_khoan = \"user\";", nativeQuery = true)
	List<NguoiDung> getAllNguoiDungs();
	
	/*
	 * @Param getAllNguoiDungsPage
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list nguoi dung page)
	 */
	@Query(value = "SELECT * FROM nguoi_dung WHERE ten_tai_khoan = 'user'",
            countQuery = "SELECT COUNT(*) FROM nguoi_dung WHERE ten_tai_khoan = 'user'",
            nativeQuery = true)
    Page<NguoiDung> getAllNguoiDungsPage(Pageable pageable);

	/*
	 * @Param findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (search nguoi dung page)
	 */
	Page<NguoiDung>findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining(Pageable pageable, String hoVaTen, String soDienThoai,String email);
}
