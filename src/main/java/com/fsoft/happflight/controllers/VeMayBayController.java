package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.ve_may_bay.VeMayBayDTO;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.chuyen_bay.ISanBayService;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import com.fsoft.happflight.utils.consts.TrangThaiXoaConsts;
import com.fsoft.happflight.services.email.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Arrays;
import java.util.List;

/**
 * VeMayBayController
 * Version: 2.0
 * @DATE May 26, 2023
 * Copyright
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * May 30, 2023         DuyNT58          update code
 */
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

    @Autowired
    ISanBayService sanBayService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailService emailService;

    /**
     * @TODO hiển thị list sân bay để người dùng chọn trong form tìm kiếm vé
     * @return List<SanBay>
     */
    @GetMapping("/listSanBay")
    public ResponseEntity<?> listSanBay() {
        return new ResponseEntity<>(sanBayService.findAll(), HttpStatus.OK);
    }

    /**
     * @TODO Tìm kiếm vé máy bay dự trên tham số truyền vào form
     * @param maVe
     * @param tenHanhKhach
     * @param diemDi
     * @param diemDen
     * @param emailNguoiDung
     * @param page
     * @param size
     * @return Page<VeMayBay>
     */
    @GetMapping("/page")
    public ResponseEntity<?> searchVeMayBay(@RequestParam(required = false) String maVe,
                                            @RequestParam(required = false) String tenHanhKhach,
                                            @RequestParam(required = false) String diemDi,
                                            @RequestParam(required = false) String diemDen,
                                            @RequestParam(required = false) String emailNguoiDung,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        NguoiDung nguoiDung = nguoiDungService.findById(emailNguoiDung);
        //get list ve may bay cho admin
        Page<VeMayBay> veMayBays = veMayBayService.pageAndSearch(maVe, tenHanhKhach, diemDi, diemDen, pageable);
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }


    /**
     * @TODO hiển thị danh sách vé máy bay dự vào mã hóa đơn chứa vé máy bay đó
     * @param page
     * @param size
     * @param maHoaDon
     * @return Page<VeMayBay>
     */
    @GetMapping(value = "/list-page")
    public ResponseEntity<?> showListFromOrderCode(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size,
                                                   @RequestParam("maHoaDon") String maHoaDon) {
        Pageable pageable = PageRequest.of(page, size);
        Page<VeMayBay> veMayBays = veMayBayService.findByOrderCode(maHoaDon, pageable);
        if (veMayBays.isEmpty()) {
            return new ResponseEntity<>(veMayBays, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

    /**
     * @TODO Tìm kiếm vé từ databse để hiển thị thông tin in vé
     * @param maVe
     * @return VeMayBay
     */
    @GetMapping("/InVe")
    public ResponseEntity<?> InVe(@RequestParam("maVe") String maVe) {
        VeMayBay veMayBay = veMayBayService.findById(maVe);
        return new ResponseEntity<>(veMayBay, HttpStatus.OK);
    }

    /**
     * @TODO Lưu hóa đơn và vé máy bay vào database
     * @param veMayBayDTO
     * @return
     */
    @PostMapping("/prePayment")
    public ResponseEntity<?> createPaymentVNPay(@RequestBody VeMayBayDTO veMayBayDTO) {
        try {
            String maHoaDon = veMayBayDTO.getHoaDonDTO().getMaHoaDon();
            if (null != hoaDonService.findById(maHoaDon) && hoaDonService.findById(maHoaDon).getTrangThaiThanhToan() == 1) {
                return new ResponseEntity<>("HÓA ĐƠN ĐÃ THANH TOÁN!", HttpStatus.OK);
            }
            NguoiDung nguoiDung = nguoiDungService.findById(veMayBayDTO.getHoaDonDTO().getEmailNguoiDung());
            if (nguoiDung == null) {
                return new ResponseEntity<>("TÀI KHOẢN " + nguoiDung.getEmail() + " KHÔNG TỒN TẠI!", HttpStatus.OK);
            }
            HoaDon hoaDon = modelMapper.map(veMayBayDTO.getHoaDonDTO(), HoaDon.class);
            hoaDon.setNguoiDung(nguoiDung);
            HoaDon hoaDonHienTai = hoaDonService.create(hoaDon);
            List<Long> maDatChoDis = Arrays.asList(veMayBayDTO.getMaDatChoDis());
            List<Long> maDatChoKhuHois = Arrays.asList(veMayBayDTO.getMaDatChoKhuHois());
            List<HanhKhachDTO> hanhKhachDTOS = veMayBayDTO.getHanhKhachDTOs();

            for (int i = 0; i < hanhKhachDTOS.size(); i++) {
                //tạo hành khách và lưu xuống DB
                //lưu tên in hoa
                hanhKhachDTOS.get(i).setTenHanhKhach(hanhKhachDTOS.get(i).getTenHanhKhach().toUpperCase());
                HanhKhach hanhKhach = hanhKhachService.saveHanhKhach(modelMapper.map(hanhKhachDTOS.get(i), HanhKhach.class));

                //nếu hành khách là em bé thì không tạo vé
                if (!hanhKhach.getLoaiHanhKhach().equals("Em Bé")) {
                    if (!maDatChoDis.isEmpty()) {
                        DatCho datChoDi = datChoService.findById(maDatChoDis.get(i));
                        //update trang thai cua datCho
                        if (datChoDi.getTrangThai().equals(TrangThaiXoaConsts.SELECTED)) {
                            return new ResponseEntity<>("GHẾ BẠN CHỌN VỪA ĐƯỢC ĐẶT", HttpStatus.NOT_FOUND);
                        }
                        datChoDi.setTrangThai(TrangThaiXoaConsts.SELECTED);
                        datChoService.update(datChoDi);
                        String maVeDi = "TK" + datChoDi.getGhe().getTenGhe() + datChoDi.getChuyenBay().getMaChuyenBay();
                        String hangVeDi = datChoDi.getGhe().getLoaiGhe().getTenLoaiGhe();
                        Long giaVeDi = datChoDi.getChuyenBay().getGiaVe();
                        VeMayBay veMayBay = new VeMayBay(maVeDi, hangVeDi, giaVeDi, 0, hanhKhach, datChoDi, hoaDonHienTai);
                        veMayBayService.create(new VeMayBay(maVeDi, hangVeDi, giaVeDi, 0, hanhKhach, datChoDi, hoaDonHienTai));
                    }

                    if (!maDatChoKhuHois.isEmpty()) {
                        //update trang thai cua datCho
                        DatCho datChoVe = datChoService.findById(maDatChoKhuHois.get(i));
                        if (datChoVe.getTrangThai().equals(TrangThaiXoaConsts.SELECTED)) {
                            return new ResponseEntity<>("GHẾ BẠN CHỌN VỪA ĐƯỢC ĐẶT", HttpStatus.NOT_FOUND);
                        }
                        datChoVe.setTrangThai(TrangThaiXoaConsts.SELECTED);
                        datChoService.update(datChoVe);
                        String maVeVe = "TK" + datChoVe.getGhe().getTenGhe() + datChoVe.getChuyenBay().getMaChuyenBay();
                        String hangVeVe = datChoVe.getGhe().getLoaiGhe().getTenLoaiGhe();
                        Long giaVeVe = datChoVe.getChuyenBay().getGiaVe();
                        veMayBayService.create(new VeMayBay(maVeVe, hangVeVe, giaVeVe, 0, hanhKhach, datChoVe, hoaDonHienTai));
                    }
                }
            }
            return new ResponseEntity<>(hoaDonHienTai, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("THANH TOÁN KHÔNG THÀNH CÔNG!", HttpStatus.OK);
        }
    }

    /**
     * @TODO Hiển thị danh sách vé máy bay từ mã hóa đơn nhập vào form tìm kiếm
     * @param maHoaDon
     * @return List<VeMayBay>
     */
    @GetMapping(value = "/list/{maHoaDon}")
    public ResponseEntity<?> showListFromOrderCode(@PathVariable("maHoaDon") String maHoaDon) {
        List<VeMayBay> veMayBays = veMayBayService.findByOrderCode(maHoaDon);
        if (veMayBays.isEmpty()) {
            return new ResponseEntity<>(veMayBays, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veMayBays, HttpStatus.OK);
    }

    /**
     * @TODO Hủy vé máy bay đối với người dùng role admin
     * @param maVe
     * @return 
     */
    @DeleteMapping("/delete/{maVe}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("maVe") String maVe) {
        //update trạng thái xóa của VeMayBay
        VeMayBay veMayBay = veMayBayService.findById(maVe);
        veMayBay.setTrangThaiXoa(1);
        veMayBayService.create(veMayBay);
        //update trạng thái của datcho thành available
        DatCho datCho = veMayBay.getDatCho();
        datCho.setTrangThai(TrangThaiXoaConsts.AVAILABLE);
        datChoService.update(datCho);
        try {
            //gửi email thông báo hủy thành công
            emailService.sendAfterCancelTicket(veMayBay);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
