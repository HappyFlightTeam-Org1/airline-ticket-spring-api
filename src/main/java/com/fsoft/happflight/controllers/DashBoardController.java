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
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.repositories.chuyen_bay.IHangBayRepository;
import com.fsoft.happflight.repositories.hanh_khach.IHanhKhachRepository;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;

@RequestMapping(value = "/dashboard")
@RestController
@CrossOrigin("*")
public class DashBoardController {

	@Autowired
	private IChuyenBayRepository iChuyenBayRepository;
	
	@Autowired
	private IHanhKhachRepository iHanhKhachRepository;
	
	@Autowired
	private INguoiDungRepository iNguoiDungRepository;
	
	@GetMapping("/total")
	public ResponseEntity<List<ChuyenBay>>getAllUser(){
		
		return new ResponseEntity<>(iChuyenBayRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/totalHK")
	public ResponseEntity<List<HanhKhach>>getHanhKhach(){
		
		return new ResponseEntity<>(iHanhKhachRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/totalND")
	public ResponseEntity<List<NguoiDung>>getNguoiDung(){
		
		return new ResponseEntity<>(iNguoiDungRepository.findAll(),HttpStatus.OK);
	}
}
