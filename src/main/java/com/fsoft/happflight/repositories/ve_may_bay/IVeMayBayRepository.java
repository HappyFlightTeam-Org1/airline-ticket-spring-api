package com.fsoft.happflight.repositories.ve_may_bay;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IVeMayBayRepository extends JpaRepository<VeMayBay, String> {
    @Query(value = "select * from ve_may_bay v join hoa_don h on v.ma_hoa_don = h.ma_hoa_don where h.ma_hoa_don =:maHoaDon and h.tt_thanh_toan = 1", nativeQuery = true)
    List<VeMayBay> findByOrderCode(@Param("maHoaDon") String maHoaDon);
    
    @Query(value="SELECT MONTH(hd.ngay_tao) AS thang, COUNT(vm.ma_ve) AS so_luong_ve\n"
    		+ "FROM hoa_don hd\n"
    		+ "INNER JOIN ve_may_bay vm ON hd.ma_hoa_don = vm.ma_hoa_don\n"
    		+ "GROUP BY thang\n"
    		+ "ORDER BY thang;",nativeQuery = true)
    List<VeMayBayThongKe> getVeMayBayThongKes();
}
