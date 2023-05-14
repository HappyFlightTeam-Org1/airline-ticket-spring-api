package com.fsoft.happflight.repositories.dat_cho;

import com.fsoft.happflight.entities.dat_cho.Ghe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IGheRepository extends JpaRepository<Ghe, Long> {
}
