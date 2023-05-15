package com.fsoft.happflight.services.chuyen_bay;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;

import java.util.List;

public interface IMayBayService {

    List<MayBay> findAll();

    MayBay findById(Long maMayBay);

}