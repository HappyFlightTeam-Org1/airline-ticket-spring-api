package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.ve_may_bay.VeMayBayDTO;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.repositories.chuyen_bay.IChuyenBayRepository;
import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;
import com.fsoft.happflight.services.chuyen_bay.ISanBayService;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/VeMayBay")
public class VeMayBayController {

    @Autowired
    private IVeMayBayService veMayBayService;

    @Autowired
    private INguoiDungService nguoiDungService;

    @Autowired
    private IDatChoService datChoService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IHanhKhachService hanhKhachService;

    @Autowired ISanBayService sanBayService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/listSanBay")
    public ResponseEntity<?> listSanBay(){
    	return new ResponseEntity<>(sanBayService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<?> searchVeMayBay(@RequestParam(required = false) String maVe,
                                            @RequestParam(required = false) String tenHanhKhach,
                                            @RequestParam(required = false) String diemDi,
                                            @RequestParam(required = false) String diemDen,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<VeMayBay> veMayBays = veMayBayService.pageAndSearch(maVe, tenHanhKhach, diemDi, diemDen,pageable);
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

  
    @GetMapping(value = "/list-page")
    public ResponseEntity<?> showListFromOrderCode(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
    		@RequestParam("maHoaDon") String maHoaDon) {
    	Pageable pageable = PageRequest.of(page, size);
        Page<VeMayBay> veMayBays = veMayBayService.findByOrderCode(maHoaDon, pageable);
        veMayBays.stream().forEach(item -> {
            System.out.println(item.toString());
        });
        if (veMayBays.isEmpty()) {
            return new ResponseEntity<>(veMayBays, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

    @GetMapping("/InVe")
    public ResponseEntity<?> InVe(@RequestParam("maVe") String maVe) {
        VeMayBay veMayBay = veMayBayService.findById(maVe);
        return new ResponseEntity<>(veMayBay, HttpStatus.OK);
    }

    @PostMapping("/prePayment")
    public ResponseEntity<?> createPaymentVNPay(@RequestBody VeMayBayDTO veMayBayDTO) {
    	System.out.println(veMayBayDTO.toString());
        try {
            String maHoaDon = veMayBayDTO.getHoaDonDTO().getMaHoaDon();
            if (null != hoaDonService.findById(maHoaDon) && hoaDonService.findById(maHoaDon).getTrangThaiThanhToan() == 1) {
                return new ResponseEntity<>("HÓA ĐƠN ĐÃ ĐƯỢC THANH TOÁN!", HttpStatus.CONFLICT);
            }
            NguoiDung nguoiDung = nguoiDungService.findById(veMayBayDTO.getHoaDonDTO().getEmailNguoiDung());
            if (nguoiDung == null) {
                return new ResponseEntity<>("TÀI KHOẢN " + nguoiDung.getEmail() + " KHÔNG TỒN TẠI!", HttpStatus.CONFLICT);
            }
            HoaDon hoaDon = modelMapper.map(veMayBayDTO.getHoaDonDTO(), HoaDon.class);
            hoaDon.setNguoiDung(nguoiDung);
            HoaDon hoaDonHienTai = hoaDonService.create(hoaDon);
            List<Long> maDatChoDis = Arrays.asList(veMayBayDTO.getMaDatChoDis());
            List<Long> maDatChoKhuHois = Arrays.asList(veMayBayDTO.getMaDatChoKhuHois());
            List<HanhKhachDTO> hanhKhachDTOS = veMayBayDTO.getHanhKhachDTOs();
            for (int i = 0; i < hanhKhachDTOS.size(); i++) {
                //tạo hành khách và lưu xuống DB
                HanhKhach hanhKhach = hanhKhachService.saveHanhKhach(modelMapper.map(hanhKhachDTOS.get(i), HanhKhach.class));

                //nếu hành khách là em bé thì không tạo vé
                if (!hanhKhach.getLoaiHanhKhach().equals("Em Bé")) {
                    if (!maDatChoDis.isEmpty()) {
                        DatCho datChoDi = datChoService.findById(maDatChoDis.get(i));
                        //update trang thai cua datCho
                        if (datChoDi.getTrangThai().equals("selected")) {
                            return new ResponseEntity<>("GHẾ BẠN CHỌN VỪA ĐƯỢC ĐẶT", HttpStatus.NOT_FOUND);
                        }
                        datChoService.update(datChoDi);
                        String maVeDi = "TK" + datChoDi.getGhe().getTenGhe() + datChoDi.getChuyenBay().getMaChuyenBay() + datChoDi.getMaDatCho();
                        String hangVeDi = datChoDi.getGhe().getLoaiGhe().getTenLoaiGhe();
                        Long giaVeDi = datChoDi.getChuyenBay().getGiaVe();
                        VeMayBay veMayBay = new VeMayBay(maVeDi, hangVeDi, giaVeDi, 0, hanhKhach, datChoDi, hoaDonHienTai);
                        System.out.println(veMayBay.toString());
//                        veMayBayService.create();
                    }

                    if (!maDatChoKhuHois.isEmpty()) {
                        //update trang thai cua datCho
                        DatCho datChoVe = datChoService.findById(maDatChoKhuHois.get(i));
                        if (datChoVe.getTrangThai().equals("selected")) {
                            return new ResponseEntity<>("GHẾ BẠN CHỌN VỪA ĐƯỢC ĐẶT", HttpStatus.NOT_FOUND);
                        }
                        datChoVe.setTrangThai("selected");
                        datChoService.update(datChoVe);
                        String maVeVe = "TK" + datChoVe.getGhe().getTenGhe() + datChoVe.getChuyenBay().getMaChuyenBay() + datChoVe.getMaDatCho();
                        String hangVeVe = datChoVe.getGhe().getLoaiGhe().getTenLoaiGhe();
                        Long giaVeVe = datChoVe.getChuyenBay().getGiaVe();
                        veMayBayService.create(new VeMayBay(maVeVe, hangVeVe, giaVeVe, 0, hanhKhach, datChoVe, hoaDonHienTai));
                    }
                }
            }
            return new ResponseEntity<>(hoaDonHienTai, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("THÊM VÉ KHÔNG THÀNH CÔNG!", HttpStatus.OK);
        }
    }

}
