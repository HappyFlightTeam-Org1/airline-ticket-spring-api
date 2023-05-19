package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/VeMayBay")
public class VeMayBayController {

    @Autowired
    private IVeMayBayService veMayBayService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> showListMayBay() {
        List<VeMayBay> veMayBays = veMayBayService.findAll();
        veMayBays.stream().forEach(item->{
            System.out.println(item.toString());
        });
        System.out.println("YEARRRRR");
        if (veMayBays.isEmpty()) {
            return new ResponseEntity<>(veMayBays, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

}
