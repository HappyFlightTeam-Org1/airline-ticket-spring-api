package com.fsoft.happflight.repositories.chuyen_bay;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fsoft.happflight.entities.chuyen_bay.HangBay;

//DucNH66 lấy danh sách hãng bay
public interface IHangBayRepository extends JpaRepository<HangBay, String> {
}
