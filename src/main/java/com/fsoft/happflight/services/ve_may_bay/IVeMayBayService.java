package com.fsoft.happflight.services.ve_may_bay;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
public interface IVeMayBayService {
	
    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param veMayBay
     * @return
     */
    VeMayBay create(VeMayBay veMayBay);

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param veMayBay
     * @return
     */
    VeMayBay delete(VeMayBay veMayBay);

    List<VeMayBay> findByOrderCode(String maHoaDon);
    /*
	 * @Param getVeMayBayThongKes
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list ve may bay thong ke)
	 */
    List<VeMayBayThongKe> getVeMayBayThongKes();

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maVe
     * @return
     */
    VeMayBay findById(String maVe);


    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maVe
     * @param tenHanhKhach
     * @param diemDi
     * @param diemDen
     * @param pageable
     * @return
     */
    Page<VeMayBay> pageAndSearch(String maVe,String tenHanhKhach, String diemDi, String diemDen, Pageable pageable);

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maVe
     * @param tenHanhKhach
     * @param diemDi
     * @param diemDen
     * @param pageable
     * @return
     */
    Page<VeMayBay> search(String maVe, String tenHanhKhach, String diemDi, String diemDen, PageRequest pageable);

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maHoaDon
     * @param pageable
     * @return
     */
    Page<VeMayBay> findByOrderCode(@Param("maHoaDon") String maHoaDon, Pageable pageable);

}
