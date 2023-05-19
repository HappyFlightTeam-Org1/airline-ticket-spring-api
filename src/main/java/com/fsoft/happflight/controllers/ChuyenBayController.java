package com.fsoft.happflight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/listPageHaiChieu")
	public ResponseEntity<?> searchChuyenBays(@RequestParam(required = false) String diemDi,
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

	@GetMapping("/listPage")
	public ResponseEntity<?> searchChuyenBay(@RequestParam(required = false) String diemDi,
			@RequestParam(required = false) String diemDen, @RequestParam(required = false) String ngayKhoiHanh,
			@RequestParam(defaultValue = "ASC") String sortDirection,
			@RequestParam(defaultValue = "giaVe") String sortBy, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Sort.Direction direction = sortDirection.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
		PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
		Page<ChuyenBay> chuyenBays = chuyenBayService.searchChuyenBay(diemDi, diemDen, ngayKhoiHanh, direction, sortBy,
				pageable);
		return new ResponseEntity<>(chuyenBays, HttpStatus.OK);
	}

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

	@GetMapping("/list")
	public ResponseEntity<?> listChuyenBay() {
		List<ChuyenBay> chuyenBays = chuyenBayService.finAll();
		if (chuyenBays.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(chuyenBays, HttpStatus.OK);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findByID(@PathVariable("id") String maChuyenBay) {
		return new ResponseEntity<>(chuyenBayService.findById(maChuyenBay), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveChuyenBayOk(@RequestBody ChuyenBayDTO chuyenBayDTO) {
		MayBay mayBay = mayBayService.findById(chuyenBayDTO.getMaMayBay());
		HangBay hangBay = hangBayService.findById(chuyenBayDTO.getMaHangBay());
		try {
			ChuyenBay chuyenBay = ModelMapperClass.convertToChuyenBay(chuyenBayDTO);
			chuyenBay.setMayBay(mayBay);
			chuyenBay.setHangBay(hangBay);
			System.out.println(chuyenBay.toString());
			chuyenBayService.save(chuyenBay);
			return ResponseEntity.ok("Thêm thành công!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thêm thất bại!");
		}
	}
}
