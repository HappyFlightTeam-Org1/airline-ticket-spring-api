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

/**
 * The Interface IChuyenBayRepository.
 * @creator DucNH66
 */
@Transactional
public interface IChuyenBayRepository extends JpaRepository<ChuyenBay, String>, JpaSpecificationExecutor<ChuyenBay> {

	/**
	 * @function Find all
	 * @creator DucNH66
	 * @param spec     the spec
	 * @param pageable the pageable
	 * @return the page
	 * @date 2023-05-26
	 */
	Page<ChuyenBay> findAll(Specification<ChuyenBay> spec, Pageable pageable);

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Query(value = "SELECT MONTH(ngay_khoi_hanh) AS month, COUNT(*) AS flight_count\n" + "FROM chuyen_bay\n"
			+ "GROUP BY MONTH(ngay_khoi_hanh)\n" + "ORDER BY month ASC;\n" + "", nativeQuery = true)
	List<ChuyenBayThongKe> getAll();

	/**
	 * Search.
	 *
	 * @param firstDay the first day
	 * @param lastDay  the last day
	 * @return the list
	 */
	@Query(value = "SELECT * FROM chuyen_bay WHERE STR_TO_DATE(ngay_khoi_hanh, '%Y-%m-%d') BETWEEN STR_TO_DATE(?1, '%Y-%m-%d') AND STR_TO_DATE(?2, '%Y-%m-%d')", nativeQuery = true)
	List<ChuyenBay> search(String firstDay, String lastDay);

	/**
	 * Gets the list month now.
	 *
	 * @return the list month now
	 */
	@Query(value = "SELECT *\n" + "FROM chuyen_bay\n" + "WHERE MONTH(ngay_khoi_hanh) = MONTH(CURRENT_DATE())\n"
			+ "  AND YEAR(ngay_khoi_hanh) = YEAR(CURRENT_DATE());", nativeQuery = true)
	List<ChuyenBay> getListMonthNow();

}
