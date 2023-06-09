package com.fsoft.happflight.services.ve_may_bay.impl;


import com.fsoft.happflight.dto.ve_may_bay.IVeMayBayDTO;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;
import com.fsoft.happflight.repositories.ve_may_bay.IVeMayBayRepository;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * VeMayBayServiceImpl
 * Version: 2.0
 *
 * @DATE May 26, 2023
 * Copyright
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * May 30, 2023         DuyNT58          update code
 */
@Service
public class VeMayBayServiceImpl implements IVeMayBayService {
    @Autowired
    private IVeMayBayRepository veMayBayRepository;

    /**
     * @param veMayBay
     * @return VeMayBay
     * @TODO tao moi hoac cap nhat VeMayBay
     */
    @Override
    public VeMayBay create(VeMayBay veMayBay) {
        return veMayBayRepository.save(veMayBay);
    }

    /**
     * @param veMayBay
     * @return VeMayBay
     * @author DuyNT58
     * @TODO Cap nhat trangThaiXoa cua VeMayBay =1
     * @UPDATE_DATE May 26, 2023
     */
    @Override
    public VeMayBay delete(VeMayBay veMayBay) {
        return veMayBayRepository.save(veMayBay);
    }


    /**
     * @param maHoaDon
     * @return List<VeMayBay>
     * @TODO Tra ve danh sach ve may bay dua vao ma dat cho nguoi dung nhap vao
     */
    @Override
    public List<VeMayBay> findByOrderCode(String maHoaDon) {
        return veMayBayRepository.findByOrderCode(maHoaDon);
    }


    /**
     * @param maVe
     * @return VeMayBay
     * @TODO Tim VeMayBay trong database de in ve hoac Huy ve
     */
    @Override
    public VeMayBay findById(String maVe) {
        return veMayBayRepository.findById(maVe).orElse(null);
    }


//    /**
//     * @TODO Tim kiem phan trang VeMayBay
//     * @param maVe
//     * @param tenHanhKhach
//     * @param diemDi
//     * @param diemDen
//     * @param pageable
//     * @return Page<VeMayBay
//     */
//    @Override
//    public Page<VeMayBay> pageAndSearch(String maVe, String tenHanhKhach, String diemDi, String diemDen, Pageable pageable) {
//
//        Specification<VeMayBay> spec = Specification.where(null);
//        if (maVe != null && !maVe.trim().isEmpty()) {
//            spec = spec.and((root, query, builder) -> builder.like(root.get("maVe"), "%" + maVe + "%"));
//        }
//
//        if (tenHanhKhach != null && !tenHanhKhach.trim().isEmpty()) {
//            spec = spec.and(
//                    (root, query, builder) -> builder.like(root.join("hanhKhach").get("tenHanhKhach"), "%" + tenHanhKhach + "%"));
//        }
//
//        if (diemDi != null && !diemDi.trim().isEmpty()) {
//            spec = spec.and((root, query, builder) -> builder.equal(root.join("datCho").join("chuyenBay").get("diemDi"),
//                    diemDi));
//        }
//
//        if (diemDen != null && !diemDen.trim().isEmpty()) {
//            spec = spec.and((root, query, builder) -> builder
//                    .equal(root.join("datCho").join("chuyenBay").get("diemDen"), diemDen));
//        }
//
//        spec = spec.and((root, query, builder) -> builder.equal(root.join("hoaDon").get("trangThaiThanhToan"), 1));
//        spec = spec.and((root, query, builder) -> builder.equal(root.get("trangThaiXoa"), 0));
//        Page<VeMayBay> result;
//        if (spec.equals(Specification.where(null))) {
//            result = veMayBayRepository.findAll(pageable);
//        } else {
//            result = veMayBayRepository.findAll(spec, pageable);
//        }
//        return result;
//    }


    /**
     * @param maVe
     * @param tenHanhKhach
     * @param diemDi
     * @param diemDen
     * @param pageable
     * @return Page<VeMayBay
            * @ TODO Tim kiem phan trang VeMayBay
     */
    @Override
    public Page<IVeMayBayDTO> getPageByAdmin(String maVe, String tenHanhKhach, String diemDi, String diemDen, Pageable pageable) {
        return veMayBayRepository.findAll("%" + maVe + "%", "%" + tenHanhKhach + "%", "%" + diemDi + "%", "%" + diemDen + "%", pageable);
    }

    @Override
    public List<VeMayBayThongKe> getVeMayBayThongKes() {
        return veMayBayRepository.getVeMayBayThongKes();
    }

    /**
     * @param maVe
     * @param tenHanhKhach
     * @param diemDi
     * @param diemDen
     * @param pageable
     * @return
     * @TODO Tim kim ve may bay
     */
    @Override
    public Page<VeMayBay> search(String maVe, String tenHanhKhach, String diemDi, String diemDen, PageRequest pageable) {
        return veMayBayRepository.search("%" + maVe + "%", "%" + tenHanhKhach + "%", "%" + diemDi + "%", "%" + diemDen + "%", pageable);
    }

    /**
     * @param maHoaDon
     * @param pageable
     * @return Page<VeMayBay>
     * @TODO Tim kiem phan trang danh sach VeMayBay dua vao ma hoa don nhap vao
     */
    @Override
    public Page<VeMayBay> findByOrderCode(String maHoaDon, Pageable pageable) {
        return veMayBayRepository.findByOrderCode(maHoaDon, pageable);
    }

}