package com.fsoft.happflight.services.hanh_khach;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;

import java.util.List;

public interface IHanhKhachService {
    void saveHanhKhach(HanhKhach hanhKhach);

    void saveHanhKhach(List<HanhKhachDTO> hanhKhachDTOs);

    List<HanhKhach> findAll();
    List<HanhKhach> findByName(String name);
}
