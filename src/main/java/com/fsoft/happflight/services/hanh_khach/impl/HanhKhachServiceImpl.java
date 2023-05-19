package com.fsoft.happflight.services.hanh_khach.impl;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.repositories.hanh_khach.IHanhKhachRepository;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HanhKhachServiceImpl implements IHanhKhachService {
    @Autowired
    IHanhKhachRepository hanhKhachRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveHanhKhach(HanhKhach hanhKhach) {
        hanhKhachRepository.save(hanhKhach);

    }

    @Override
    public void saveHanhKhach(List<HanhKhachDTO> hanhKhachDTOs) {
        hanhKhachDTOs.stream().forEach(item -> {
            HanhKhach hanhKhach = modelMapper.map(item, HanhKhach.class);
            hanhKhachRepository.save(hanhKhach);
        });
    }


    @Override
    public List<HanhKhach> findAll() {
        return hanhKhachRepository.findAll();
    }

    @Override
    public Page<HanhKhach> findByName(Pageable pageable,String tenHanhKhach) {
        return hanhKhachRepository.findByTenHanhKhachContainingIgnoreCase(pageable,tenHanhKhach);
    }

    @Override
    public Page<HanhKhach> findWithPageAble(Pageable pageable) {
        return hanhKhachRepository.findAll(pageable);
    }


}
