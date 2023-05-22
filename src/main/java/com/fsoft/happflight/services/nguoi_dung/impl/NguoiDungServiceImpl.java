package com.fsoft.happflight.services.nguoi_dung.impl;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class NguoiDungServiceImpl implements INguoiDungService {

    @Autowired
    private INguoiDungRepository nguoiDungRepository;
    @Override
    public NguoiDung findById(String email) {
        return nguoiDungRepository.findById(email).orElse(null);
    }
}
