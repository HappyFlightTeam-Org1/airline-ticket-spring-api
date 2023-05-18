package com.fsoft.happflight.repositories.dat_cho;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IDatChoRepository extends JpaRepository<DatCho, Long> {

    @Query(value = "SELECT * FROM dat_cho WHERE dat_cho.ma_chuyen_bay=:id", nativeQuery = true)
    List<DatCho> getAllByChuyenBayId(@Param("id") String id);
}
