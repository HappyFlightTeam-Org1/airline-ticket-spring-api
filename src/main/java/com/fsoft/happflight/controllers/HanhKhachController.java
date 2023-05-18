package com.fsoft.happflight.controllers;
import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.hanh_khach.SearchCriteria;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import org.springframework.beans.factory.annotation.Autowired;
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

        @GetMapping("/list")
        public ResponseEntity<List<HanhKhach>> listHanhKhach() {
            List<HanhKhach> hanhKhachs = hanhKhachService.findAll();
            return new ResponseEntity<>(hanhKhachs, HttpStatus.OK);

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

//        @PostMapping("/search")
//        public ResponseEntity<List<HanhKhach>> FindListHanhKhachByTenHanhKhach(@RequestBody SearchCriteria criteria) {
//            List<HanhKhach> hanhKhachList = hanhKhachService.findByName(criteria.getTenHanhKhach());
//            if (hanhKhachList.isEmpty()) {
//                return new ResponseEntity<>(hanhKhachList, HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(hanhKhachList, HttpStatus.OK);
//        }

    @GetMapping("/search")
    public ResponseEntity<List<HanhKhach>> FindListHanhKhachByName(@RequestParam(name="tenHanhKhach") String tenHanhKhach) {
        List<HanhKhach> hanhKhachList = hanhKhachService.findByName(tenHanhKhach);
        if (hanhKhachList.isEmpty()) {
            return new ResponseEntity<>(hanhKhachList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hanhKhachList, HttpStatus.OK);
    }
    }

