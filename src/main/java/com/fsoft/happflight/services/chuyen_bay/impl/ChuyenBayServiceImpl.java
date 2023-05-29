package com.fsoft.happflight.services.chuyen_bay.impl;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayServiceImpl implements IChuyenBayService {
    @Autowired
    IChuyenBayRepository chuyenBayRepository;

    @Autowired
    private IDatChoService datChoService;

    //DucNH66 thêm mới chuyến bay
    @Override
    public void save(ChuyenBay chuyenBay) {
        System.out.println(chuyenBay.toString());
        chuyenBayRepository.save(chuyenBay);
        //DuyNT58 them danh sach dat cho khi them moi chuyen bay
        datChoService.autoCreateDatCho(chuyenBay);
    }

    //DucNH66 tìm kiếm chuyến bay eho Id
    @Override
    public ChuyenBay findById(String maChuyenBay) {
        return chuyenBayRepository.findById(maChuyenBay).orElse(null);
    }

    //DucNH66 tìm kiếm sắp xếp phân trang chuyến bay cho Admin
    @Override
    public Page<ChuyenBay> searchChuyenBayAdmin(String diemDi, String diemDen, String ngayKhoiHanh,
                                                Direction sortDirection, String sortBy, Pageable pageable) {
        Specification<ChuyenBay> spec = Specification.where(null);

        if (diemDi != null && !diemDi.trim().isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("diemDi"), diemDi));
        }

        if (diemDen != null && !diemDen.trim().isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("diemDen"), diemDen));
        }

        if (ngayKhoiHanh != null && !ngayKhoiHanh.trim().isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("ngayKhoiHanh"), ngayKhoiHanh));
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


    //DucNH66 tìm kiếm sắp xếp phân trang chuyến bay cho User
    @Override
    public Page<ChuyenBay> searchChuyenBay(String diemDi, String diemDen, String ngayKhoiHanh,
                                           Direction sortDirection, String sortBy, Pageable pageable) {
        Specification<ChuyenBay> spec = Specification.where(null);

        if (diemDi != null && !diemDi.isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("diemDi"), diemDi));
        }

        if (diemDen != null && !diemDen.isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("diemDen"), diemDen));
        }

        if (ngayKhoiHanh != null) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("ngayKhoiHanh"), ngayKhoiHanh));
        }

        Pageable pageableWithSort = pageable;
        if (sortBy != null && !sortBy.isEmpty()) {
            Sort sort = Sort.by(sortDirection, sortBy);
            pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        }
        return chuyenBayRepository.findAll(spec, pageableWithSort);
    }

    /*
     * @Param getListMonthNow
     * @creator TITT
     * @date-create 26-05-2023
     * @function (list chuyen bay month now)
     */
    @Override
    public List<ChuyenBay> getListMonthNow() {
        return chuyenBayRepository.getListMonthNow();
    }


}
