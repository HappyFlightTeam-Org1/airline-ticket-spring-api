package com.fsoft.happflight.services.ve_may_bay.impl;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.repositories.ve_may_bay.IVeMayBayRepository;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeMayBayServiceImpl implements IVeMayBayService {

    private IVeMayBayRepository veMayBayRepository;

    @Autowired
    public VeMayBayServiceImpl(IVeMayBayRepository veMayBayRepository) {
        this.veMayBayRepository = veMayBayRepository;
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

    @Override
    public Page<VeMayBay> search(String maVe, String tenHanhKhach, String diemDi, String diemDen, PageRequest pageable) {
        return veMayBayRepository.search("%" + maVe + "%", "%" + tenHanhKhach + "%", "%" + diemDi + "%",  "%" + diemDen + "%", pageable);
    }
}
