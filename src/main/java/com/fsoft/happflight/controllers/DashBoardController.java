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
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBayThongKe;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.repositories.hanh_khach.IHanhKhachRepository;
import com.fsoft.happflight.repositories.hoa_don.IHoaDonRepository;
import com.fsoft.happflight.repositories.ve_may_bay.IVeMayBayRepository;

@RequestMapping(value = "/dashboard")
@RestController
@CrossOrigin("*")
public class DashBoardController {

	@Autowired
	private IChuyenBayRepository iChuyenBayRepository;
	
	@Autowired
	private IHanhKhachRepository iHanhKhachRepository;
	
	@Autowired
	private IHoaDonRepository iHoaDonRepository;
	
	@Autowired
	private IVeMayBayRepository iVeMayBayRepository;
	
	/*
	 * @Param getChuyenBay
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list chuyen bay)
	 */
	@GetMapping("/total")
	public ResponseEntity<List<ChuyenBay>>getChuyenBay(){
		
		return new ResponseEntity<>(iChuyenBayRepository.findAll(),HttpStatus.OK);
	}
	
	/*
	 * @Param getHanhKhach
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list hanh khach)
	 */
	@GetMapping("/totalHK")
	public ResponseEntity<List<HanhKhach>>getHanhKhach(){
		
		return new ResponseEntity<>(iHanhKhachRepository.findAll(),HttpStatus.OK);
	}
	
	/*
	 * @Param getHoaDon
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list hoa don)
	 */
	@GetMapping("/hoadon")
	public ResponseEntity<List<HoaDon>>getHoaDon(){
		
		return new ResponseEntity<>(iHoaDonRepository.findAll(),HttpStatus.OK);
	}
	
	/*
	 * @Param getChuyenBayThongKe
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list chuyen bay )
	 */
	@GetMapping("/chuyenbaythongke")
	public ResponseEntity<List<ChuyenBayThongKe>>getChuyenBayThongKe(){
		
		return new ResponseEntity<>(iChuyenBayRepository.getAll(),HttpStatus.OK);
	}
	
	/*
	 * @Param getHoaDonThongKe
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list hoa don thong ke )
	 */
	@GetMapping("/hoadonthongke")
	public ResponseEntity<List<HoaDonThongKe>>getHoaDonThongKe(){
		
		return new ResponseEntity<>(iHoaDonRepository.getHoaDonThongKe(),HttpStatus.OK);
	}
	
	/*
	 * @Param tinhTongTienHoaDon
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (tong tien )
	 */
	@GetMapping("/tongtien")
    public Float tinhTongTienHoaDon() {
        List<HoaDon> danhSachHoaDon = iHoaDonRepository.findAll();
        Float tongTien = 0.0f;

        for (HoaDon hoaDon : danhSachHoaDon) {
            tongTien += hoaDon.getTongTien();
        }

        return tongTien;
    }
	
	/*
	 * @Param searchChuyenBay
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list chuyen bay )
	 */
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
    
    /*
	 * @Param getListChuyenBayMonthNow
	 * @creator TITT
	 * @date-create 26-05-2023
	 * @function (list chuyen bay month now)
	 */
    @GetMapping("/list-chuyen-bay-month-now")
    public ResponseEntity<List<ChuyenBay>> getListChuyenBayMonthNow(){
    	
    	return new ResponseEntity<>(iChuyenBayRepository.getListMonthNow(),HttpStatus.OK);
    }
    
    /*
  	 * @Param getVeMayBayThongKe
  	 * @creator TITT
  	 * @date-create 26-05-2023
  	 * @function (list ve may bay thong ke)
  	 */
    @GetMapping("/list-ve-may-bay-thong-ke")
    public ResponseEntity<List<VeMayBayThongKe>> getVeMayBayThongKe(){
    	return new ResponseEntity<>(iVeMayBayRepository.getVeMayBayThongKes(),HttpStatus.OK);
    }
    
    /*
  	 * @Param getSoLuongKhachHangThangNay
  	 * @creator TITT
  	 * @date-create 26-05-2023
  	 * @function (so luong hanh khach thang nay)
  	 */
    @GetMapping("/so-luong-hanh-khach-thang-nay")
    public int getSoLuongKhachHangThangNay(){
    	return iHanhKhachRepository.soLuongKhachHangThangNay();
    }
}
