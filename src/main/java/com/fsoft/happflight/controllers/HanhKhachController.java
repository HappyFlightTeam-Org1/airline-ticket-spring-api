package com.fsoft.happflight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;

@RestController
@CrossOrigin("*")
@RequestMapping("/hanh-khach")
public class HanhKhachController {
	@Autowired
	private IHanhKhachService hanhKhachService;
	
	   @GetMapping("/list")
	    public ResponseEntity<List<HanhKhach>> listHanhKhach(){
	    	List<HanhKhach> hanhKhachs=hanhKhachService.findAll();
			return new ResponseEntity<>(hanhKhachs,HttpStatus.OK);
	    	
	    }

	@PostMapping("/save")
	public ResponseEntity<String> saveHanhHanh(@RequestBody List<HanhKhachDTO> hanhKhachDTOs) {
		try {
			hanhKhachService.saveHanhKhach(hanhKhachDTOs);
			return ResponseEntity.ok("Lưu hành khách thành công");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lưu hành khách thất bại");
		}

	}
}
