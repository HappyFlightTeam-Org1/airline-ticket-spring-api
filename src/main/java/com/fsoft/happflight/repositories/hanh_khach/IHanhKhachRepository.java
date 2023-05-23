package com.fsoft.happflight.repositories.hanh_khach;

import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IHanhKhachRepository extends JpaRepository<HanhKhach, Long> {

    Page<HanhKhach> findByTenHanhKhachContainingIgnoreCase(Pageable pageable,String tenHanhkhach);

    Page<HanhKhach> findAll(Pageable pageable);


}
