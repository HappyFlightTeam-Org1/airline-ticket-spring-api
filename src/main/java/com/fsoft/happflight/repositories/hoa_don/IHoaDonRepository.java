package com.fsoft.happflight.repositories.hoa_don;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.hoa_don.HoaDonThongKe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@Repository
@Transactional
public interface IHoaDonRepository extends JpaRepository<HoaDon, String> {
	
	/*
	 * @Param getHoaDonThongKe
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list hoa don thong ke)
	 */
	@Query(value = "SELECT MONTH(ngay_tao) AS thang, SUM(tong_tien) AS tong_tien_thang\n"
			+ "FROM hoa_don\n"
			+ "GROUP BY MONTH(ngay_tao);\n"
			+ "", nativeQuery = true)
	List<HoaDonThongKe> getHoaDonThongKe();
}
