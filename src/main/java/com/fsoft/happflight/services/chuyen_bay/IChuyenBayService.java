package com.fsoft.happflight.services.chuyen_bay;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

import java.util.List;

public interface IChuyenBayService {

    void save(ChuyenBay chuyenBay);

    List<ChuyenBay> finAll();
    
    ChuyenBay findById(String maChuyenBay);

}
