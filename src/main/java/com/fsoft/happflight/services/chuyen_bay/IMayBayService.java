package com.fsoft.happflight.services.chuyen_bay;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMayBayService.
 */
public interface IMayBayService {

    /**
     * Find all.
     *
     * @return the list
     */
    List<MayBay> findAll();

    /**
     * Find by id.
     *
     * @param maMayBay the ma may bay
     * @return the may bay
     */
    MayBay findById(Long maMayBay);

}