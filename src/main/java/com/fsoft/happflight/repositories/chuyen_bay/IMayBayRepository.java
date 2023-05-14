package com.fsoft.happflight.repositories.chuyen_bay;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IMayBayRepository extends JpaRepository<MayBay, String> {

}
