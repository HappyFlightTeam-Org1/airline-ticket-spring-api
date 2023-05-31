package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.hanh_khach.SearchCriteria;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/hanh-khach")
public class HanhKhachController {
	@Autowired
	private IHanhKhachService hanhKhachService;

	/**
	 * @Author: DuyenTTM7
	 * @Day: May 26, 2023 | @Time: 7:51:52 PM
	 * @Return: ResponseEntity<List<HanhKhach>>
	 */
	@GetMapping("/list")
	public ResponseEntity<List<HanhKhach>> listHanhKhach() {
		List<HanhKhach> hanhKhachs = hanhKhachService.findAll();
		return new ResponseEntity<>(hanhKhachs, HttpStatus.OK);

	}

	/**
	 * @Author: DuyenTTM7
	 * @Day: May 26, 2023 | @Time: 7:51:49 PM
	 * @Return: Page<HanhKhach>
	 */
	@GetMapping("/list-with-page")
	public Page<HanhKhach> getAllHanhKhach(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return hanhKhachService.findWithPageAble(pageable);
	}


	/**
	 * @function Save Hanh Khach
	 * @create DucNH66
	 * @param hanhKhachDTOs the hanh khach DTos
	 * @return the response entity
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveHanhKhach(@RequestBody List<HanhKhachDTO> hanhKhachDTOs) {
		try {
			hanhKhachService.saveHanhKhach(hanhKhachDTOs);
			return ResponseEntity.ok("Lưu hành khách thành công");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lưu hành khách thất bại");
		}

	}


	/**
	 * @Author: DuyenTTM7
	 * @Day: May 26, 2023 | @Time: 7:51:41 PM
	 * @Return: Page<HanhKhach>
	 */
	@GetMapping("/search")
	public Page<HanhKhach> FindListHanhKhachByName(
			@RequestParam(name = "tenHanhKhach") String tenHanhKhach,@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<HanhKhach> hanhKhachList;
		if(!"".equals(tenHanhKhach)){
		hanhKhachList = hanhKhachService.findByName(pageable,tenHanhKhach);}
		else {
			hanhKhachList = hanhKhachService.findWithPageAble(pageable);
		}
		return hanhKhachList;
	}
}
