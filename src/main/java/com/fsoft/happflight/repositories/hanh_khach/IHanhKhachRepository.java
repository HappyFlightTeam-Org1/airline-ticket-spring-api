package com.fsoft.happflight.repositories.hanh_khach;

import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IHanhKhachRepository extends JpaRepository<HanhKhach, Long> {

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:04 PM
     * @Return: Page<HanhKhach>
     */
    Page<HanhKhach> findByTenHanhKhachContainingIgnoreCase(Pageable pageable,String tenHanhkhach);

    
    /**
     *
     */
    Page<HanhKhach> findAll(Pageable pageable);


	/*
	 * @Param soLuongKhachHangThangNay
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (so luong khach hang thang nay)
	 */

    @Query(value="SELECT COUNT(DISTINCT hk.ma_hanh_khach) AS so_luong_hanh_khach\n"
    		+ "FROM hanh_khach hk\n"
    		+ "JOIN ve_may_bay vb ON hk.ma_hanh_khach = vb.ma_hanh_khach\n"
    		+ "JOIN hoa_don hd ON vb.ma_hoa_don = hd.ma_hoa_don\n"
    		+ "WHERE MONTH(hd.ngay_tao) = MONTH(CURRENT_DATE()) AND YEAR(hd.ngay_tao) = YEAR(CURRENT_DATE());",nativeQuery = true)
   int soLuongKhachHangThangNay();
}
