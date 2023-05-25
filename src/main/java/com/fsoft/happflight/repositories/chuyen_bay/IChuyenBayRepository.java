package com.fsoft.happflight.repositories.chuyen_bay;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBayThongKe;

@Transactional
public interface IChuyenBayRepository extends JpaRepository<ChuyenBay, String>, JpaSpecificationExecutor<ChuyenBay> {
//DucNH66 tìm kiếm phân trang sắp xếp chuyến bay
	Page<ChuyenBay> findAll(Specification<ChuyenBay> spec, Pageable pageable);
    
	@Query(value="SELECT MONTH(ngay_khoi_hanh) AS month, COUNT(*) AS flight_count\n"
			+ "FROM chuyen_bay\n"
			+ "GROUP BY MONTH(ngay_khoi_hanh)\n"
			+ "ORDER BY month ASC;\n"
			+ "",nativeQuery = true)
	List<ChuyenBayThongKe> getAll();
	
	@Query(value="SELECT * FROM chuyen_bay WHERE STR_TO_DATE(ngay_khoi_hanh, '%Y-%m-%d') BETWEEN STR_TO_DATE(?1, '%Y-%m-%d') AND STR_TO_DATE(?2, '%Y-%m-%d')", nativeQuery = true)
	List<ChuyenBay> search(String firstDay, String lastDay);

}
