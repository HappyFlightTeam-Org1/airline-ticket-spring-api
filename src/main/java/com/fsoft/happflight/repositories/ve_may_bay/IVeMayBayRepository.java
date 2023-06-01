package com.fsoft.happflight.repositories.ve_may_bay;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;

@Transactional
public interface IVeMayBayRepository extends JpaRepository<VeMayBay, String>,JpaSpecificationExecutor<VeMayBay> {
	
    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maHoaDon
     * @param pageable
     * @return Page <VeMayBay>
     */	
	Page <VeMayBay> findAll(Specification<VeMayBay> spec,Pageable pageable); 
	
    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maHoaDon
     * @return List<VeMayBay>
     */
    @Query(value = "select * from ve_may_bay v join hoa_don h on v.ma_hoa_don = h.ma_hoa_don where h.ma_hoa_don =:maHoaDon and h.tt_thanh_toan = 1 and v.trang_thai_xoa =0", nativeQuery = true)
    List<VeMayBay> findByOrderCode(@Param("maHoaDon") String maHoaDon);


    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maHoaDon
     * @param pageable
     * @return Page <VeMayBay>
     */
    @Query(value = "select * from ve_may_bay v join hoa_don h on v.ma_hoa_don = h.ma_hoa_don where h.ma_hoa_don =:maHoaDon and h.tt_thanh_toan = 1 and v.trang_thai_xoa =0",
    		countQuery = "select COUNT(*) from ve_may_bay v join hoa_don h on v.ma_hoa_don = h.ma_hoa_don where h.ma_hoa_don =:maHoaDon and h.tt_thanh_toan = 1 and v.trang_thai_xoa =0",nativeQuery = true)
    Page<VeMayBay> findByOrderCode(@Param("maHoaDon") String maHoaDon, Pageable pageable);

       
	/*
	 * @Param getVeMayBayThongKes
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list ve may bay thong ke)
	 */  
    @Query(value="SELECT MONTH(hd.ngay_tao) AS thang, COUNT(vm.ma_ve) AS so_luong_ve\n"
    		+ "FROM hoa_don hd\n"
    		+ "INNER JOIN ve_may_bay vm ON hd.ma_hoa_don = vm.ma_hoa_don\n"
    		+ "GROUP BY thang\n"
    		+ "ORDER BY thang;",nativeQuery = true)
    List<VeMayBayThongKe> getVeMayBayThongKes();

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maVe
     * @param tenHanhKhach
     * @param diemDi
     * @param diemDen
     * @param pageable
     * @return Page <VeMayBay>
     */
    @Query(value = "select ve_may_bay.ma_ve, ve_may_bay.gia_ve, ve_may_bay.hang_ve, " +
            "ve_may_bay.ma_dat_cho, ve_may_bay.ma_hanh_khach, " +
            "ve_may_bay.ma_hoa_don, ve_may_bay.trang_thai_xoa from ve_may_bay " +
            "join hanh_khach on hanh_khach.ma_hanh_khach = ve_may_bay.ma_hanh_khach " +
            "join dat_cho on ve_may_bay.ma_dat_cho = dat_cho.ma_dat_cho " +
            "join chuyen_bay on chuyen_bay.ma_chuyen_bay = dat_cho.ma_chuyen_bay " +
            "where ve_may_bay.trang_thai_xoa like 0 " +
            "and ve_may_bay.ma_ve like :maVe " +
            "and hanh_khach.ten_hanh_khach like :tenHanhKhach " +
            "and chuyen_bay.diem_di like :diemDi " +
            "and chuyen_bay.diem_den like :diemDen", nativeQuery = true)
    Page<VeMayBay> search(
            @Param("maVe") String maVe,
            @Param("tenHanhKhach") String tenHanhKhach,
            @Param("diemDi") String diemDi,
            @Param("diemDen") String diemDen,
            Pageable pageable
    );


    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param maVe
     * @return Optional<VeMayBay>
     */
    @Query(value = "select * from ve_may_bay where ma_ve =:maVe and trang_thai_xoa =0", nativeQuery = true)
    Optional<VeMayBay> findById(@Param("maVe") String maVe);


}

