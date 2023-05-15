package com.fsoft.happflight.repositories.chuyen_bay;

import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHangBayRepository extends JpaRepository<HangBay, String> {
}
