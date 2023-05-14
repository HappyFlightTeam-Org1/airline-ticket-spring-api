package com.fsoft.happflight.services.dat_cho.impl;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.repositories.dat_cho.IDatChoRepository;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatChoServiceImpl implements IDatChoService {

    private IDatChoRepository datChoRepository;

    public DatChoServiceImpl(IDatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public DatCho create(DatCho datCho) {
        return this.datChoRepository.save(datCho);
    }

    @Override
    public List<DatCho> findAll() {
        return this.datChoRepository.findAll();
    }

    @Override
    public void update(DatCho datCho) {
        this.datChoRepository.save(datCho);
    }

}
