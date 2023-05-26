package com.fsoft.happflight.services.ve_may_bay;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVeMayBayService {
    VeMayBay create(VeMayBay veMayBay);

    VeMayBay delete(VeMayBay veMayBay);

    List<VeMayBay> findByOrderCode(String maHoaDon);

    List<VeMayBayThongKe> getVeMayBayThongKes();


    VeMayBay findById(String maVe);

//    , String tenHanhKhach, String diemDi, String diemDen,

    Page<VeMayBay> pageAndSearch(String maVe,String tenHanhKhach, String diemDi, String diemDen, Pageable pageable);

    Page<VeMayBay> search(String maVe, String tenHanhKhach, String diemDi, String diemDen, PageRequest pageable);


}
