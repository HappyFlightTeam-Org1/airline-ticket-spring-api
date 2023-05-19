package com.fsoft.happflight.repositories.hoa_don;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IHoaDonRepository extends JpaRepository<HoaDon, String> {
}
