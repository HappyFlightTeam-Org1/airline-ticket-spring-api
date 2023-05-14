package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.services.chuyen_bay.IMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestRest {

    private IMayBayService mayBayService;

    @Autowired
    public TestRest(IMayBayService mayBayService) {
        this.mayBayService = mayBayService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MayBay>> showListMayBay() {
        List<MayBay> mayBayList = mayBayService.findAll();
        if (mayBayList.isEmpty()) {
            return new ResponseEntity<>(mayBayList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mayBayList, HttpStatus.OK);
    }
}
