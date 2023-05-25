package com.fsoft.happflight.services.ve_may_bay;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVeMayBayService {

    Page<VeMayBay> findAll(Pageable pageable);

    VeMayBay create(VeMayBay veMayBay);

    VeMayBay delete(VeMayBay veMayBay);

    List<VeMayBay> findByOrderCode(String maHoaDon);

    VeMayBay findById(String maVe);

    Page<VeMayBay> search(String maVe, String tenHanhKhach, String diemDi, String diemDen, PageRequest pageable);
}
