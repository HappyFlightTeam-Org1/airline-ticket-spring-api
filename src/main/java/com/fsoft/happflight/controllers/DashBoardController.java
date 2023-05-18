package com.fsoft.happflight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;

@RequestMapping(value = "/dashboard")
@RestController
@CrossOrigin("*")
public class DashBoardController {

	@Autowired
	private IChuyenBayRepository iChuyenBayRepository;
	
	@GetMapping("/total")
	public ResponseEntity<List<ChuyenBay>>getAllUser(){
		
		return new ResponseEntity<>(iChuyenBayRepository.findAll(),HttpStatus.OK);
	}
	
}
