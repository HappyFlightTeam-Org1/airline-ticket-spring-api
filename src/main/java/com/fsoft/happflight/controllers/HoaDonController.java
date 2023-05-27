package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import com.fsoft.happflight.utils.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hoa-don")
public class HoaDonController {

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IDatChoService datChoService;

    @Autowired
    private IVeMayBayService veMayBayService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/update/{id}")
    public ResponseEntity<?> findByID(@PathVariable("id") String maHoaDon) {
        HoaDon hoaDon = hoaDonService.findById(maHoaDon);
        if (hoaDon.getTrangThaiThanhToan() == 0) {
            List<VeMayBay> veMayBays = veMayBayService.findByOrderCode(maHoaDon);
            DatCho datCho;
            //update trang thai của ghe trong chuyen bay
            for (int i = 0; i < veMayBays.size(); i++) {
                datCho = veMayBays.get(i).getDatCho();
                datCho.setTrangThai("selected");
                datChoService.update(datCho);
            }
            hoaDon.setTrangThaiThanhToan(1);
            // GỬI MAIL SAU KHI THANH TOÁN THÀNH CÔNG
            try {
                emailService.sendPaymentMail(hoaDon);
            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<>("GỬI MAIL THẤT BẠI", HttpStatus.OK);
            }
            if (hoaDonService.update(hoaDon) != null) {
                return new ResponseEntity<>("THANH TOÁN THÀNH CÔNG", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("PAID", HttpStatus.OK);
        }
        return new ResponseEntity<>("THANH TOÁN THẤT BẠI", HttpStatus.OK);
    }

}
