package com.fsoft.happflight.services.chuyen_bay.impl;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.repositories.chuyen_bay.IMayBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MayBayServiceImpl implements IMayBayService {

    private IMayBayRepository mayBayRepository;

    public MayBayServiceImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Autowired
    public MayBayServiceImpl(IMayBayRepository mayBayRepository) {
        super();
        this.mayBayRepository = mayBayRepository;
    }

    @Override
    public List<MayBay> findAll() {
        return mayBayRepository.findAll();
    }

    @Override
    public MayBay findById(Long maMayBay) {
        return mayBayRepository.findById(maMayBay).orElse(null);
    }

}