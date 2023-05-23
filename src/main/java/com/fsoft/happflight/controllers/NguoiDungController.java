package com.fsoft.happflight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;

@RequestMapping(value = "/nguoi-dung")
@RestController
@CrossOrigin("*")
public class NguoiDungController {
	
	@Autowired
	private INguoiDungService iNguoiDungService;
		
	@GetMapping("/list")
	public ResponseEntity<List<NguoiDung>> listNguoiDung() {
		List<NguoiDung> nguoiDungs = iNguoiDungService.getAllNguoiDungs();
		return new ResponseEntity<>(nguoiDungs, HttpStatus.OK);

	}
	
	@GetMapping("/list-page")
	public Page<NguoiDung> getAllNguoiDungPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return iNguoiDungService.getAllNguoiDungsPage(pageable);
	}

	@GetMapping("/search")
	public Page<NguoiDung> FindListSearch(
			@RequestParam(name = "hoVaTen",defaultValue = "") String hoVaTen,
			@RequestParam(name = "soDienThoai",defaultValue = "") String soDienThoai,
			@RequestParam(name = "email",defaultValue = "") String email,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		  Pageable pageable = PageRequest.of(page, size);
		  Page<NguoiDung> nguoiDungPage;
			nguoiDungPage = iNguoiDungService.findByHoVaTenContainingAndSoDienThoaiContainingAndEmailContaining(pageable, hoVaTen, soDienThoai, email);		
		return nguoiDungPage;
	}
}
