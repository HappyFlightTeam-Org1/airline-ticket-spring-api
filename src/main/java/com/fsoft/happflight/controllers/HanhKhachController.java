package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.hanh_khach.SearchCriteria;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/HanhKhach")
public class HanhKhachController {

    @Autowired
    private IHanhKhachService hanhKhachService;

    @GetMapping("/list")
    public ResponseEntity<List<HanhKhach>> showListHanhKhach() {
        List<HanhKhach> hanhKhachList = hanhKhachService.findAll();
        if (hanhKhachList.isEmpty()) {
            return new ResponseEntity<>(hanhKhachList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hanhKhachList, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<HanhKhach>> FindListHanhKhachByTenHanhKhach(@RequestBody SearchCriteria criteria) {
        List<HanhKhach> hanhKhachList = hanhKhachService.findByName(criteria.getTenHanhKhach());
        if (hanhKhachList.isEmpty()) {
            return new ResponseEntity<>(hanhKhachList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hanhKhachList, HttpStatus.OK);
    }
}
