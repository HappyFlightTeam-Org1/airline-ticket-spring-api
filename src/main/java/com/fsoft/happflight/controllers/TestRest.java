package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.chuyen_bay.ChuyenBay;
import com.fsoft.happflight.entities.dat_cho.Ghe;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.repositories.nguoi_dung.INguoiDungRepository;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.dat_cho.IGheService;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestRest {
//    @Autowired
//    private IMayBayService mayBayService;

    @Autowired
    private IVeMayBayService veMayBayService;

    @Autowired
    private INguoiDungRepository nguoiDungRepository;

    @Autowired
    private IDatChoService datChoService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IHanhKhachService hanhKhachService;

    @Autowired
    private IGheService gheService;

//    @Autowired
//    public TestRest(IMayBayService mayBayService) {
//        this.mayBayService = mayBayService;
//    }

//    @GetMapping("/list")
//    public ResponseEntity<List<MayBay>> showListMayBay() {
//        List<MayBay> mayBayList = mayBayService.findAll();
//        if (mayBayList.isEmpty()) {
//            return new ResponseEntity<>(mayBayList, HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(mayBayList, HttpStatus.OK);
//    }

    @GetMapping("/ghes")
    public ResponseEntity<List<Ghe>> showListGhe() {
        List<Ghe> ghes = gheService.findAll();
        if (ghes.isEmpty()) {
            return new ResponseEntity<>(ghes, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ghes, HttpStatus.OK);
    }

    @PostMapping("/saveVeMayBay")
    public ResponseEntity<String> saveTicket() {
        try {
            HoaDon hoaDon = hoaDonService.findById("OD1019279");
            System.out.println(hoaDon.toString());
            List<HanhKhach> hanhKhachs = hanhKhachService.findAll();
            for (int i = 1; i <= hanhKhachs.size(); i++) {
                System.out.println(i);
                String id = "TK00" + i;
                HanhKhach hanhKhach = hanhKhachs.get(i - 1);
                System.out.println(hanhKhach.toString());
                VeMayBay veMayBay = new VeMayBay(id, datChoService.findById(Long.parseLong(String.valueOf(i))).getGhe().getLoaiGhe().getTenLoaiGhe(), 2000000L, 0, hanhKhach, datChoService.findById(Long.parseLong(String.valueOf(i))), hoaDon);
                System.out.println(veMayBay.toString());
                veMayBayService.create(veMayBay);
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thêm thất bại!");
        }
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<?> showListFromOrderCode(@PathVariable("email") String email) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(email).orElse(null);
        return new ResponseEntity<>(nguoiDung, HttpStatus.OK);
    }

    @GetMapping("/listPageAdmin")
    public ResponseEntity<?> searchVeMayBay(@RequestParam(required = false) String maVe,
                                            @RequestParam(required = false) String tenHanhKhach,
                                            @RequestParam(required = false) String diemDi,
                                            @RequestParam(required = false) String diemDen,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size) {
//        Sort.Direction direction = sortDirection.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        PageRequest pageable = PageRequest.of(page, size);
        Page<VeMayBay> veMayBays = veMayBayService.search(maVe, tenHanhKhach, diemDi, diemDen,pageable);
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }
}
