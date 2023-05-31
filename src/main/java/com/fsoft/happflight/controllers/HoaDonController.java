package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.email.EmailService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
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

    /**
     * @param maHoaDon
     * @return
     * @author DuyNT58
     * @TODO update trang thai hoa don thanh da thanh toan
     * @UPDATE_DATE May 26, 2023
     */
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateAfterPayment(@PathVariable("id") String maHoaDon) {
        HoaDon hoaDon = hoaDonService.findById(maHoaDon);
        if (null != hoaDon) {
            if(hoaDon.getTrangThaiThanhToan() == 0){
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
                    return new ResponseEntity<>("DONE", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("THANH TOÁN THẤT BẠI", HttpStatus.OK);
                }
            }
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.OK);
        }
        return new ResponseEntity<>("THANH TOÁN THẤT BẠI", HttpStatus.OK);
    }

}
