package com.fsoft.happflight.services.dat_cho.impl;

import com.fsoft.happflight.entities.dat_cho.Ghe;
import com.fsoft.happflight.repositories.dat_cho.IGheRepository;
import com.fsoft.happflight.services.dat_cho.IGheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GheServiceImpl implements IGheService {

    private IGheRepository gheRepository;

    @Autowired
    public GheServiceImpl(IGheRepository gheRepository) {
        this.gheRepository = gheRepository;
    }

    @Override
    public List<Ghe> findAll() {
        return gheRepository.findAll();
    }
}
