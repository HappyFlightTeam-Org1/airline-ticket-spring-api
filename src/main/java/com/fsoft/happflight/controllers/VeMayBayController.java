package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.DataChuyenBayFindById;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/VeMayBay")
public class VeMayBayController {

    @Autowired
    private IVeMayBayService veMayBayService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> showListVeMayBay(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "5") int size) {

        Page<VeMayBay> pageVeMayBays = veMayBayService.findAll(PageRequest.of(page, size));
        List<VeMayBay> veMayBays = pageVeMayBays.getContent();
        veMayBays.stream().forEach(item -> {
            System.out.println(item.toString());
        });
        if (veMayBays.isEmpty()) {
            return new ResponseEntity<>(veMayBays, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

    @GetMapping(value = "/list/{maHoaDon}")
    public ResponseEntity<?> showListFromOrderCode(@PathVariable("maHoaDon") String maHoaDon) {
        List<VeMayBay> veMayBays = veMayBayService.findByOrderCode(maHoaDon);
        veMayBays.stream().forEach(item -> {
            System.out.println(item.toString());
        });
        if (veMayBays.isEmpty()) {
            return new ResponseEntity<>(veMayBays, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

    @GetMapping("/InVe")
    public ResponseEntity<?> InVe(@RequestParam("maVe") String maVe) {
        VeMayBay veMayBay = veMayBayService.findById(maVe);
        return new ResponseEntity<>(veMayBay, HttpStatus.OK);
    }

}
