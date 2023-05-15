package com.fsoft.happflight.controllers;

import com.fsoft.happflight.config.ModelMapperClass;
import com.fsoft.happflight.dto.chuyen_bay.ChuyenBayDTO;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;
import com.fsoft.happflight.services.chuyen_bay.IHangBayService;
import com.fsoft.happflight.services.chuyen_bay.IMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    @Autowired
//    ISanBayService sanBayService;

    @GetMapping("/list")
    public ResponseEntity<List<ChuyenBay>> listChuyenBay() {
        List<ChuyenBay> chuyenBays = chuyenBayService.finAll();
        if (chuyenBays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(chuyenBays, HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveChuyenBayOk(@RequestBody ChuyenBayDTO chuyenBayDTO) {
        MayBay mayBay = mayBayService.findById(chuyenBayDTO.getMaMayBay());
        HangBay hangBay = hangBayService.findById(chuyenBayDTO.getMaHangBay());
        try {
            ChuyenBay chuyenBay = ModelMapperClass.convertToChuyenBay(chuyenBayDTO);
            chuyenBay.setMayBay(mayBay);
            chuyenBay.setHangBay(hangBay);
            chuyenBay.setTrangThaiXoa(0);
            System.out.println(chuyenBay.toString());
            chuyenBayService.save(chuyenBay);
            return ResponseEntity.ok("Thêm thành công!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thêm thất bại!");
        }
    }
}
