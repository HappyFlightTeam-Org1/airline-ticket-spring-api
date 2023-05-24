package com.fsoft.happflight.repositories.chuyen_bay;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;

@Transactional
public interface IChuyenBayRepository extends JpaRepository<ChuyenBay, String>, JpaSpecificationExecutor<ChuyenBay> {
//DucNH66 tìm kiếm phân trang sắp xếp chuyến bay
	Page<ChuyenBay> findAll(Specification<ChuyenBay> spec, Pageable pageable);

}
