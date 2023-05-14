package com.fsoft.happflight.repositories.hanh_khach;

import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IHanhKhachRepository extends JpaRepository<HanhKhach, Long> {

}
