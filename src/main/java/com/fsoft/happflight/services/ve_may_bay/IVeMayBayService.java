package com.fsoft.happflight.services.ve_may_bay;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

import java.util.List;

public interface IVeMayBayService {

    List<VeMayBay> findAll();

    VeMayBay create(VeMayBay veMayBay);

    VeMayBay delete(VeMayBay veMayBay);

}
