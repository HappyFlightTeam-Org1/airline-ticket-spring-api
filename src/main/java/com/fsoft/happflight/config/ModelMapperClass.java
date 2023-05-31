package com.fsoft.happflight.config;

import com.fsoft.happflight.dto.chuyen_bay.ChuyenBayDTO;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperClass {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ChuyenBay convertToChuyenBay(ChuyenBayDTO chuyenBayDTO) {
        return modelMapper.map(chuyenBayDTO, ChuyenBay.class);
    }
}
