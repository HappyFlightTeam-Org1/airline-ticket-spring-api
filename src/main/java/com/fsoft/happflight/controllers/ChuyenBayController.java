package com.fsoft.happflight.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsoft.happflight.config.ModelMapperClass;
import com.fsoft.happflight.dto.DataChuyenBayFindById;
import com.fsoft.happflight.dto.DataChuyenBaySearch;
import com.fsoft.happflight.dto.DataResponse;
import com.fsoft.happflight.dto.chuyen_bay.ChuyenBayDTO;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.entities.chuyen_bay.SanBay;
import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;
import com.fsoft.happflight.services.chuyen_bay.IHangBayService;
import com.fsoft.happflight.services.chuyen_bay.IMayBayService;
import com.fsoft.happflight.services.chuyen_bay.ISanBayService;
@RestController
@RequestMapping(value = "/chuyen-bay")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChuyenBayController {

	@Autowired
	IChuyenBayService chuyenBayService;

	@Autowired
	IMayBayService mayBayService;

	@Autowired
	IHangBayService hangBayService;

	@Autowired
	ISanBayService sanBayService;
	
   //DucNH66 Lấy dữ liệu các bảng liên quan
	@GetMapping("/listSelectOption")
	public ResponseEntity<?> listSelectOption() {
		List<SanBay> sanBays = sanBayService.findAll();
		List<HangBay> hangBays = hangBayService.findAll();
		List<MayBay> mayBays = mayBayService.findAll();
		DataResponse dataResponse = new DataResponse();
		dataResponse.setMayBays(mayBays);
		dataResponse.setHangBays(hangBays);
		dataResponse.setSanBays(sanBays);
		return new ResponseEntity<>(dataResponse, HttpStatus.OK);
	}

 
	//DucNH66 List cho User
	@GetMapping("/listPageUser")
	public ResponseEntity<?> searchChuyenBayUser(@RequestParam(required = false) String diemDi,
			@RequestParam(required = false) String diemDen, @RequestParam(required = false) String ngayDi,
			@RequestParam(required = false) String ngayDiKh, @RequestParam(defaultValue = "ASC") String sortDirection,
			@RequestParam(defaultValue = "giaVe") String sortBy, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Sort.Direction direction = sortDirection.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
		PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
		Page<ChuyenBay> chuyenBay1Chieu = chuyenBayService.searchChuyenBay(diemDi, diemDen, ngayDi, direction, sortBy,
				pageable);
		Page<ChuyenBay> chuyenBayKhuHoi = chuyenBayService.searchChuyenBay(diemDen, diemDi, ngayDiKh, direction, sortBy,
				pageable);
		DataChuyenBaySearch dataChuyenBaySearch = new DataChuyenBaySearch();
		dataChuyenBaySearch.setChuyenBay1Chieu(chuyenBay1Chieu);
		dataChuyenBaySearch.setChuyenBayKhuHoi(chuyenBayKhuHoi);
		return new ResponseEntity<>(dataChuyenBaySearch, HttpStatus.OK);
	}
	
    //DucNH66 List cho Admin 
	@GetMapping("/listPageAdmin")
	public ResponseEntity<?> searchChuyenBayAdmin(@RequestParam(required = false) String diemDi,
			@RequestParam(required = false) String diemDen, @RequestParam(required = false) String ngayKhoiHanh,
			@RequestParam(defaultValue = "ASC") String sortDirection,
			@RequestParam(defaultValue = "giaVe") String sortBy, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Sort.Direction direction = sortDirection.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
		PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
		Page<ChuyenBay> chuyenBays = chuyenBayService.searchChuyenBayAdmin(diemDi, diemDen, ngayKhoiHanh, direction, sortBy,
				pageable);
		return new ResponseEntity<>(chuyenBays, HttpStatus.OK);
	}


	//DucNH66 Thông tin chuyến bay được chọn 1 chiều/ khứ hồi
	@GetMapping("/findBy2Id")
	public ResponseEntity<?> findBy2ID(@RequestParam String idChuyenBayDi,
			@RequestParam String idChuyenBayKhuHoi) {
		ChuyenBay chuyenBay1Chieu = chuyenBayService.findById(idChuyenBayDi);
		ChuyenBay chuyenBayKhuHoi = chuyenBayService.findById(idChuyenBayKhuHoi);
		DataChuyenBayFindById dataChuyenBayFindById = new DataChuyenBayFindById();
		dataChuyenBayFindById.setChuyenBay1(chuyenBay1Chieu);
		dataChuyenBayFindById.setChuyenBay2(chuyenBayKhuHoi);
		return new ResponseEntity<>(dataChuyenBayFindById, HttpStatus.OK);
	}

	
    //DucNH66 Thông tin chuyến bay cần chỉnh sửa/xem chi tiết
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findByID(@PathVariable("id") String maChuyenBay) {
		return new ResponseEntity<>(chuyenBayService.findById(maChuyenBay), HttpStatus.OK);
	}

	
	//DucNH66 Thêm mới chuyến bay
	@PostMapping("/save")
	public ResponseEntity<?> saveChuyenBayOk( @Valid
		@RequestBody ChuyenBayDTO chuyenBayDTO,BindingResult bindingResult) {
		chuyenBayDTO.validate(chuyenBayDTO, bindingResult);
		   if (bindingResult.hasErrors()) {
		        Map<String, String> errorMessages = new HashMap<>();
		        for (FieldError error : bindingResult.getFieldErrors()) {
		            errorMessages.put(error.getField(), error.getDefaultMessage());
		        }
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
		    }

		MayBay mayBay = mayBayService.findById(chuyenBayDTO.getMaMayBay());
		HangBay hangBay = hangBayService.findById(chuyenBayDTO.getMaHangBay());
		try {
			ChuyenBay chuyenBay = ModelMapperClass.convertToChuyenBay(chuyenBayDTO);
			chuyenBay.setMayBay(mayBay);
			chuyenBay.setHangBay(hangBay);
			chuyenBayService.save(chuyenBay);
			return ResponseEntity.ok("Thêm thành công!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Thêm thất bại!");
		}
	}
}
