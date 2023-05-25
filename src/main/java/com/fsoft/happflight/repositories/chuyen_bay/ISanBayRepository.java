package com.fsoft.happflight.repositories.chuyen_bay;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fsoft.happflight.entities.chuyen_bay.SanBay;


//DucNH66 lấy danh sách sân bay
public interface ISanBayRepository extends JpaRepository<SanBay, Long> {

}