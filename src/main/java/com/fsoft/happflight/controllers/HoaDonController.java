package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hoa-don")
public class HoaDonController {

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IDatChoService datChoService;

    @Autowired
    private IVeMayBayService veMayBayService;

    @PostMapping("/update/{id}")
    public ResponseEntity<?> findByID(@PathVariable("id") String maHoaDon) {
        HoaDon hoaDon = hoaDonService.findById(maHoaDon);
        List<VeMayBay> veMayBays = veMayBayService.findByOrderCode(maHoaDon);
        DatCho datCho;
        //update trang thai của ghe trong chuyen bay
        for (int i = 0; i < veMayBays.size(); i++) {
            datCho = veMayBays.get(i).getDatCho();
            datCho.setTrangThai("selected");
            datChoService.update(datCho);
        }
        hoaDon.setTrangThaiThanhToan(1);
        System.out.println("UPDATE HOA DON!");
        System.out.println(hoaDon.toString());
        if (hoaDonService.update(hoaDon) != null) {
            return new ResponseEntity<>("THANH TOÁN THÀNH CÔNG", HttpStatus.OK);
        }
        return new ResponseEntity<>("THANH TOÁN THẤT BẠI", HttpStatus.OK);
    }


}
