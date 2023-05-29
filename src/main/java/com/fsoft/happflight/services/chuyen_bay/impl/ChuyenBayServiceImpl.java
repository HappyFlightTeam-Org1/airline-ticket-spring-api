package com.fsoft.happflight.services.chuyen_bay.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.dat_cho.Ghe;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;
import com.fsoft.happflight.services.dat_cho.IDatChoService;

/**
 * The Class ChuyenBayServiceImpl.
 * 
 * @creator DucNH66
 */
@Service
public class ChuyenBayServiceImpl implements IChuyenBayService {

	/** The chuyen bay repository. */
	@Autowired
	IChuyenBayRepository chuyenBayRepository;

	/** The dat cho service. */
	@Autowired
	private IDatChoService datChoService;

	/**
	 * Save.
	 * 
	 * @creator DucNH66
	 * @date 2023-05-26
	 * @param chuyenBay the chuyen bay
	 */
	@Override
	public void save(ChuyenBay chuyenBay) {
		System.out.println(chuyenBay.toString());
		chuyenBayRepository.save(chuyenBay);
		// DuyNT58 them danh sach dat cho khi them moi chuyen bay
		List<Ghe> ghes = chuyenBay.getMayBay().getGhes();
		DatCho datCho = new DatCho();
		ghes.stream().forEach(ghe -> {
			datCho.setTrangThai("available");
			datCho.setGhe(ghe);
			datCho.setChuyenBay(chuyenBay);
			datChoService.create(datCho);
		});
	}

	/**
	 * Find by id.
	 * 
	 * @creator DucNH66
	 * @param maChuyenBay the ma chuyen bay
	 * @date 2023-05-26
	 * @return the chuyen bay
	 */
	// DucNH66 tìm kiếm chuyến bay eho Id
	@Override
	public ChuyenBay findById(String maChuyenBay) {
		return chuyenBayRepository.findById(maChuyenBay).orElse(null);
	}

	/**
	 * Search chuyen bay admin.
	 * 
	 * @creator DucNH66
	 * @date 2023-05-26
	 * @param diemDi        the diem di
	 * @param diemDen       the diem den
	 * @param ngayKhoiHanh  the ngay khoi hanh
	 * @param sortDirection the sort direction
	 * @param sortBy        the sort by
	 * @param pageable      the pageable
	 * @return the page
	 */
	// DucNH66 tìm kiếm sắp xếp phân trang chuyến bay cho Admin
	@Override
	public Page<ChuyenBay> searchChuyenBayAdmin(String diemDi, String diemDen, String ngayKhoiHanh,
			Direction sortDirection, String sortBy, Pageable pageable) {
		Specification<ChuyenBay> spec = Specification.where(null);

		if (diemDi != null && !diemDi.trim().isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("diemDi"), diemDi));
		}

		if (diemDen != null && !diemDen.trim().isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("diemDen"), diemDen));
		}

		if (ngayKhoiHanh != null && !ngayKhoiHanh.trim().isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("ngayKhoiHanh"), ngayKhoiHanh));
		}

		Pageable pageableWithSort = pageable;
		if (sortBy != null && !sortBy.trim().isEmpty()) {
			Sort sort = Sort.by(sortDirection, sortBy);
			pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		}

		Page<ChuyenBay> result;
		if (spec.equals(Specification.where(null))) {
			result = chuyenBayRepository.findAll(pageableWithSort);
		} else {
			result = chuyenBayRepository.findAll(spec, pageableWithSort);
		}
		return result;
	}

	/**
	 * Search chuyen bay.
	 * 
	 * @creator DucNH66
	 * @date 2023-05-26
	 * @param diemDi        the diem di
	 * @param diemDen       the diem den
	 * @param ngayKhoiHanh  the ngay khoi hanh
	 * @param sortDirection the sort direction
	 * @param sortBy        the sort by
	 * @param pageable      the pageable
	 * @return the page
	 */
	// DucNH66 tìm kiếm sắp xếp phân trang chuyến bay cho User
	@Override
	public Page<ChuyenBay> searchChuyenBay(String diemDi, String diemDen, String ngayKhoiHanh, Direction sortDirection,
			String sortBy, Pageable pageable) {
		Specification<ChuyenBay> spec = Specification.where(null);

		if (diemDi != null && !diemDi.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("diemDi"), diemDi));
		}

		if (diemDen != null && !diemDen.isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("diemDen"), diemDen));
		}

		if (ngayKhoiHanh != null) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("ngayKhoiHanh"), ngayKhoiHanh));
		}

		Pageable pageableWithSort = pageable;
		if (sortBy != null && !sortBy.isEmpty()) {
			Sort sort = Sort.by(sortDirection, sortBy);
			pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		}
		return chuyenBayRepository.findAll(spec, pageableWithSort);
	}

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
	@Override
	public List<ChuyenBay> getListMonthNow() {
		return chuyenBayRepository.getListMonthNow();
	}

}
