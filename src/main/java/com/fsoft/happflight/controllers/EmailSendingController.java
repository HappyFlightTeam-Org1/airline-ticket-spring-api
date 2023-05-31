package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.email.CancelEmailDTO;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * EmailSendingController
 * Version: 2.0
 *
 * @DATE May 26, 2023
 * Copyright
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * May 30, 2023         DuyNT58          update code
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/Email")
public class EmailSendingController {

    @Autowired
    private EmailService emailService;

    /**
     * @param cancelEmailDTO
     * @return
     * @TODO Lưu hóa đơn và vé máy bay vào database
     */
    @PostMapping("/cancel")
    public ResponseEntity<?> createPaymentVNPay(@RequestBody CancelEmailDTO cancelEmailDTO) {
        System.out.println("SOUSDFSDFHDFSDFSDFSDF");
        try {
            emailService.sendAfterCancelTicket(cancelEmailDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("GỬI EMAIL KHÔNG THÀNH CÔNG!", HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>("GỬI EMAIL THÀNH CÔNG!", HttpStatus.OK);
    }
}
