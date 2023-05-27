package com.fsoft.happflight.services.hanh_khach;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHanhKhachService {
	
	List<HanhKhach> findAll();
    HanhKhach saveHanhKhach(HanhKhach hanhKhach);

    /**
     * Save hanh khach.
     * @creator DucNH66
     * @param hanhKhachDTOs the hanh khach DT os
     */
    void saveHanhKhach(List<HanhKhachDTO> hanhKhachDTOs);

    Page<HanhKhach> findByName(Pageable pageable,String name);

    Page<HanhKhach> findWithPageAble(Pageable pageable);
    
    int soLuongKhachHangThangNay();
}
