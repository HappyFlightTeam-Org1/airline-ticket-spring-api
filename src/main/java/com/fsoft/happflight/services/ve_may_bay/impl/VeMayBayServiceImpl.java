package com.fsoft.happflight.services.ve_may_bay.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.repositories.ve_may_bay.IVeMayBayRepository;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;

@Service
public class VeMayBayServiceImpl implements IVeMayBayService {

	private IVeMayBayRepository veMayBayRepository;

	@Autowired
	public VeMayBayServiceImpl(IVeMayBayRepository veMayBayRepository) {
	}

	@Override
	public Page<VeMayBay> findAll(Pageable pageable) {
		System.out.println("SERRVICCCCEE !");
		return veMayBayRepository.findAll(pageable);
	}

	@Override
	public VeMayBay create(VeMayBay veMayBay) {
		return veMayBayRepository.save(veMayBay);
	}

	@Override
	public VeMayBay delete(VeMayBay veMayBay) {
		return veMayBayRepository.save(veMayBay);
	}

	@Override
	public List<VeMayBay> findByOrderCode(String maHoaDon) {
		return veMayBayRepository.findByOrderCode(maHoaDon);
	}

	@Override
	public VeMayBay findById(String maVe) {
		return veMayBayRepository.findById(maVe).orElse(null);
	}

	// DucNH66 tìm kiếm phân trang vé máy bay
	@Override
	public Page<VeMayBay> pageAndSearch(String maVe, String tenHanhKhach, String diemDi, String diemDen,
			Pageable pageable) {
		
		Specification<VeMayBay> spec = Specification.where(null);
		if (maVe != null ) {
			spec = spec.and((root, query, builder) -> builder.equal(root.get("maVe"), maVe));
		}

//		if (tenHanhKhach != null ) {
//			spec = spec.and(
//					(root, query, builder) -> builder.equal(root.join("hanhKhach").get("tenHanhKhach"), tenHanhKhach));
//		}
//
//		if (diemDi != null ) {
//			spec = spec.and((root, query, builder) -> builder.equal(root.join("datCho").join("chuyenBay").get("diemDi"),
//					diemDi));
//		}
//
//		if (diemDen != null) {
//			spec = spec.and((root, query, builder) -> builder
//					.equal(root.join("datCho").join("chuyenBay").get("diemDen"), diemDen));
//		}

		Page<VeMayBay> result;
		if (spec.equals(Specification.where(null))) {
		    result = veMayBayRepository.findAll(pageable);
		} else {
		    result = veMayBayRepository.findAll(spec, pageable);
		}
		return result;
	}

}
