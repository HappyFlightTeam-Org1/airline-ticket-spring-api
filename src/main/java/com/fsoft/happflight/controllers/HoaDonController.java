package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hoa-don")
public class HoaDonController {

    @Autowired
    private IHoaDonService hoaDonService;

    @PostMapping("/update/{id}")
    public ResponseEntity<?> findByID(@PathVariable("id") String maHoaDon) {
        HoaDon hoaDon = hoaDonService.findById(maHoaDon);
        hoaDon.setTrangThaiThanhToan(1);
        if( hoaDonService.update(hoaDon)!= null){
            return new ResponseEntity<>("THANH TOÁN THÀNH CÔNG", HttpStatus.OK);
        }
         return new ResponseEntity<>("THANH TOÁN THẤT BẠI", HttpStatus.OK);
    }


}
