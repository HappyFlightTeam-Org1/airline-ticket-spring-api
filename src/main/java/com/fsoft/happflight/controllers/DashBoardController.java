package com.fsoft.happflight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBayThongKe;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.hoa_don.HoaDonThongKe;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.repositories.hanh_khach.IHanhKhachRepository;
import com.fsoft.happflight.repositories.hoa_don.IHoaDonRepository;
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
	
	@Autowired
	private IHoaDonRepository iHoaDonRepository;
	
	
	@GetMapping("/total")
	public ResponseEntity<List<ChuyenBay>>getChuyenBay(){
		
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
	
	@GetMapping("/hoadon")
	public ResponseEntity<List<HoaDon>>getHoaDon(){
		
		return new ResponseEntity<>(iHoaDonRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/chuyenbaythongke")
	public ResponseEntity<List<ChuyenBayThongKe>>getChuyenBayThongKe(){
		
		return new ResponseEntity<>(iChuyenBayRepository.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/hoadonthongke")
	public ResponseEntity<List<HoaDonThongKe>>getHoaDonThongKe(){
		
		return new ResponseEntity<>(iHoaDonRepository.getHoaDonThongKe(),HttpStatus.OK);
	}
	
	@GetMapping("/tongtien")
    public Float tinhTongTienHoaDon() {
        List<HoaDon> danhSachHoaDon = iHoaDonRepository.findAll();
        Float tongTien = 0.0f;

        for (HoaDon hoaDon : danhSachHoaDon) {
            tongTien += hoaDon.getTongTien();
        }

        return tongTien;
    }
	
    @GetMapping("/listchuyenbay")
    public ResponseEntity<List<ChuyenBay>> searchChuyenBay(
            @RequestParam(required = false) String firstDay,
            @RequestParam(required = false) String lastDay) {
    	List<ChuyenBay> chuyenBays;
    	if (firstDay != null && lastDay != null) {
            chuyenBays = iChuyenBayRepository.search(firstDay, lastDay);
        } else {
            chuyenBays = iChuyenBayRepository.findAll(); 
        }
        return new ResponseEntity<>(chuyenBays, HttpStatus.OK);
    }
}
