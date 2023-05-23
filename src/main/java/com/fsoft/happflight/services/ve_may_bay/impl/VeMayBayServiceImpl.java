package com.fsoft.happflight.services.ve_may_bay.impl;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.repositories.ve_may_bay.IVeMayBayRepository;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<VeMayBay> findAll() {
        System.out.println("SERRVICCCCEE !");
        return veMayBayRepository.findAll();
    }

    @Override
    public VeMayBay create(VeMayBay veMayBay) {
        return veMayBayRepository.save(veMayBay);
    }

    @Override
    public VeMayBay delete(VeMayBay veMayBay) {
        return veMayBayRepository.save(veMayBay);
    }
}
