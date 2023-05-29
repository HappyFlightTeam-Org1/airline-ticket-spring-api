package com.fsoft.happflight.services.ve_may_bay.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;
import com.fsoft.happflight.repositories.ve_may_bay.IVeMayBayRepository;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;

@Service
public class VeMayBayServiceImpl implements IVeMayBayService {
	@Autowired
	private IVeMayBayRepository veMayBayRepository;


	/**
	 * @author DuyNT58
	 * @TODO tao moi VeMayBay
	 * @UPDATE_DATE May 26, 2023
	 * @param veMayBay
	 * @return VeMayBay
	 */
	@Override
	public VeMayBay create(VeMayBay veMayBay) {
		return veMayBayRepository.save(veMayBay);
	}

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE May 26, 2023
	 * @param veMayBay
	 * @return VeMayBay
	 */
	@Override
	public VeMayBay delete(VeMayBay veMayBay) {
		return veMayBayRepository.save(veMayBay);
	}

	/**
	 * @author DuyNT58
	 * @TODO lay List<VeMayBay> tu ma hoa don
	 * @UPDATE_DATE May 26, 2023
	 * @param maHoaDon
	 * @return List<VeMayBay>
	 */
	@Override
	public List<VeMayBay> findByOrderCode(String maHoaDon) {
		return veMayBayRepository.findByOrderCode(maHoaDon);
	}


	/**
	 * @author DuyNT58
	 * @TODO tim ve may bay de in hoac huy
	 * @UPDATE_DATE May 26, 2023
	 * @param maVe
	 * @return VeMayBay
	 */
	@Override
	public VeMayBay findById(String maVe) {
		return veMayBayRepository.findById(maVe).orElse(null);
	}
	


	// DucNH66 tìm kiếm phân trang vé máy bay
	@Override
	public Page<VeMayBay> pageAndSearch(String maVe,String tenHanhKhach, String diemDi, String diemDen,Pageable pageable) {
		
		Specification<VeMayBay> spec = Specification.where(null);
		if (maVe != null && !maVe.trim().isEmpty() ) {
			spec = spec.and((root, query, builder) -> builder.like(root.get("maVe"),"%"+ maVe+"%"));
		}

		if (tenHanhKhach != null && !tenHanhKhach.trim().isEmpty() ) {
			spec = spec.and(
					(root, query, builder) -> builder.like(root.join("hanhKhach").get("tenHanhKhach"), "%"+tenHanhKhach+"%"));
		}

		if (diemDi != null && !diemDi.trim().isEmpty()) {
			spec = spec.and((root, query, builder) -> builder.equal(root.join("datCho").join("chuyenBay").get("diemDi"),
					diemDi));
		}

		if (diemDen != null && !diemDen.trim().isEmpty()) {
			spec = spec.and((root, query, builder) -> builder
					.equal(root.join("datCho").join("chuyenBay").get("diemDen"), diemDen));
		}

		spec = spec.and((root, query, builder) -> builder.equal(root.join("hoaDon").get("trangThaiThanhToan"), 1));
		spec = spec.and((root, query, builder) -> builder.equal(root.get("trangThaiXoa"), 0));
		
		Page<VeMayBay> result;
		if (spec.equals(Specification.where(null))) {
		    result = veMayBayRepository.findAll(pageable);
		} else {
		    result = veMayBayRepository.findAll(spec, pageable);
		}
		return result;
	}
	

	@Override
	public List<VeMayBayThongKe> getVeMayBayThongKes() {
		return veMayBayRepository.getVeMayBayThongKes();
	}

 

    @Override
    public Page<VeMayBay> search(String maVe, String tenHanhKhach, String diemDi, String diemDen, PageRequest pageable) {
        return veMayBayRepository.search("%" + maVe + "%", "%" + tenHanhKhach + "%", "%" + diemDi + "%",  "%" + diemDen + "%", pageable);
    }

	@Override
	public Page<VeMayBay> findByOrderCode(String maHoaDon, Pageable pageable) {
		
		return veMayBayRepository.findByOrderCode(maHoaDon, pageable);
	}

}
