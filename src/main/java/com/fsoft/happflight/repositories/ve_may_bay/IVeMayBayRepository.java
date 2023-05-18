package com.fsoft.happflight.repositories.ve_may_bay;

import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IVeMayBayRepository extends JpaRepository<VeMayBay, String> {
}
