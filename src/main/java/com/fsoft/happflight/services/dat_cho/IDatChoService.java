package com.fsoft.happflight.services.dat_cho;

import com.fsoft.happflight.entities.dat_cho.DatCho;

import java.util.List;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
public interface IDatChoService {

    void create(DatCho datCho);

    List<DatCho> findAll();

    void update(DatCho datCho);

    List<DatCho> getAllByChuyenBayId(String id);

    DatCho findById(Long id);
}
