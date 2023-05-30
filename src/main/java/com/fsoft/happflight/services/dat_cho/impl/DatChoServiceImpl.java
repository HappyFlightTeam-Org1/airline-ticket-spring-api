package com.fsoft.happflight.services.dat_cho.impl;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.dat_cho.Ghe;
import com.fsoft.happflight.repositories.dat_cho.IDatChoRepository;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatChoServiceImpl implements IDatChoService {

    private IDatChoRepository datChoRepository;

    @Autowired
    public DatChoServiceImpl(IDatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public void create(DatCho datCho) {
        this.datChoRepository.create(datCho.getTrangThai(), datCho.getGhe().getMaGhe(), datCho.getChuyenBay().getMaChuyenBay());
    }

    @Override
    public List<DatCho> findAll() {
        return this.datChoRepository.findAll();
    }

    @Override
    public void update(DatCho datCho) {
        this.datChoRepository.save(datCho);
    }

    @Override
    public List<DatCho> getAllByChuyenBayId(String id) {
        return datChoRepository.getAllByChuyenBayId(id);
    }

    @Override
    public DatCho findById(Long id) {
        return datChoRepository.findById(id).orElse(null);
    }

    @Override
    public void autoCreateDatCho(ChuyenBay chuyenBay) {
        List<Ghe> ghes = chuyenBay.getMayBay().getGhes();
        DatCho datCho = new DatCho();
        ghes.stream().forEach(ghe -> {
            datCho.setTrangThai("available");
            datCho.setGhe(ghe);
            datCho.setChuyenBay(chuyenBay);
            datChoRepository.create(datCho.getTrangThai(), datCho.getGhe().getMaGhe(), datCho.getChuyenBay().getMaChuyenBay());
        });
    }

}
