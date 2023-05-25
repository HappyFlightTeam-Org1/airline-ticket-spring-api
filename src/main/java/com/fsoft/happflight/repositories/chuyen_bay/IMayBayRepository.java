package com.fsoft.happflight.repositories.chuyen_bay;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;

//DucNH66 lấy danh sách máy bay
public interface IMayBayRepository extends JpaRepository<MayBay, Long> {

}
