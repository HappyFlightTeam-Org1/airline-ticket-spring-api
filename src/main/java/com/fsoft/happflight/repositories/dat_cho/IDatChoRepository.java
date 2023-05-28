package com.fsoft.happflight.repositories.dat_cho;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@Repository
@Transactional
public interface IDatChoRepository extends JpaRepository<DatCho, Long> {

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param id
     * @return List<DatCho>
     */
    @Query(value = "SELECT * FROM dat_cho WHERE dat_cho.ma_chuyen_bay=:id", nativeQuery = true)
    List<DatCho> getAllByChuyenBayId(@Param("id") String id);

    /**
     * @author DuyNT58
     * @TODO tu dong them moi datCho khi tao moi ChuyenBay
     * @UPDATE_DATE May 26, 2023
     * @param trangThai
     * @param maGhe
     * @param maChuyenBay
     */
    @Modifying
    @Query(value = "INSERT INTO dat_cho(trang_thai, ma_ghe, ma_chuyen_bay) VALUE \n" +
            "            (:trangThai, :maGhe, :maChuyenBay );", nativeQuery = true)
    void create(@Param("trangThai") String trangThai,
                      @Param("maGhe") Long maGhe,
                      @Param("maChuyenBay") String maChuyenBay);
}
