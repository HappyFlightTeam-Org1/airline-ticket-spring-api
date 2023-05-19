package com.fsoft.happflight.controllers;

import com.fsoft.happflight.config.ModelMapperClass;
import com.fsoft.happflight.dto.chuyen_bay.ChuyenBayDTO;
import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.chuyen_bay.HangBay;
import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.entities.dat_cho.Ghe;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;
import com.fsoft.happflight.services.chuyen_bay.IMayBayService;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.dat_cho.IGheService;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestRest {

    private IMayBayService mayBayService;

    @Autowired
    private IVeMayBayService veMayBayService;

    @Autowired
    private INguoiDungRepository nguoiDungRepository;

    @Autowired
    private IHanhKhachService hanhKhachService;

    @Autowired
    private IDatChoService datChoService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IGheService gheService;

    @Autowired
    public TestRest(IMayBayService mayBayService) {
        this.mayBayService = mayBayService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MayBay>> showListMayBay() {
        List<MayBay> mayBayList = mayBayService.findAll();
        if (mayBayList.isEmpty()) {
            return new ResponseEntity<>(mayBayList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mayBayList, HttpStatus.OK);
    }

    @GetMapping("/ghes")
    public ResponseEntity<List<Ghe>> showListGhe() {
        List<Ghe> ghes = gheService.findAll();
        if (ghes.isEmpty()) {
            return new ResponseEntity<>(ghes, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ghes, HttpStatus.OK);
    }

    @PostMapping("/saveVeMayBay")
    public ResponseEntity<String> saveTicket(@RequestBody ChuyenBayDTO chuyenBayDTO) {
        try {
//        NguoiDung nguoiDung = nguoiDungRepository.findById("admin@gmail.com").orElse(null);
            HoaDon hoaDon = hoaDonService.findById("OD23JS524");
//        HanhKhach hanhKhach = hanhKhachService.saveHanhKhach()
            return ResponseEntity.ok("Thêm thành công!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thêm thất bại!");
        }
    }
}
