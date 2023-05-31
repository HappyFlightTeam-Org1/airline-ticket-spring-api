package com.fsoft.happflight.services.chuyen_bay;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

/**
 * The Interface IChuyenBayService.
 */
public interface IChuyenBayService {

	/**
	 * Save.
	 *
	 * @param chuyenBay the chuyen bay
	 */
	void save(ChuyenBay chuyenBay);

	/**
	 * Find by id.
	 *
	 * @param maChuyenBay the ma chuyen bay
	 * @return the chuyen bay
	 */
	ChuyenBay findById(String maChuyenBay);

	/**
	 * Search chuyen bay.
	 *
	 * @param diemDi        the diem di
	 * @param diemDen       the diem den
	 * @param ngayKhoiHanh  the ngay khoi hanh
	 * @param sortDirection the sort direction
	 * @param sortBy        the sort by
	 * @param pageable      the pageable
	 * @return the page
	 */
	Page<ChuyenBay> searchChuyenBay(String diemDi, String diemDen, String ngayKhoiHanh, Direction sortDirection,
			String sortBy, Pageable pageable);

	/**
	 * Search chuyen bay admin.
	 *
	 * @param diemDi        the diem di
	 * @param diemDen       the diem den
	 * @param ngayKhoiHanh  the ngay khoi hanh
	 * @param sortDirection the sort direction
	 * @param sortBy        the sort by
	 * @param pageable      the pageable
	 * @return the page
	 */
	Page<ChuyenBay> searchChuyenBayAdmin(String diemDi, String diemDen, Pageable pageable);

	/**
	 * Gets the list month now.
	 *
	 * @return the list month now
	 * 
	 *         /*
	 * @Param getListMonthNow
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list chuyen bay month now)
	 * 
	 */
	List<ChuyenBay> getListMonthNow();

}
