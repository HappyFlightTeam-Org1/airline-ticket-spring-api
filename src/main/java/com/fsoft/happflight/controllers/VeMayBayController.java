package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/VeMayBay")

public class VeMayBayController {

    @Autowired
    private IHanhKhachService hanhKhachService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<String> saveHanhHanh(@RequestBody List<HanhKhachDTO> hanhKhachDTOs) {
        try {
            hanhKhachService.saveHanhKhach(hanhKhachDTOs);
            return ResponseEntity.ok("Lưu hành khách thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lưu hành khách thất bại");
        }

    }

}
