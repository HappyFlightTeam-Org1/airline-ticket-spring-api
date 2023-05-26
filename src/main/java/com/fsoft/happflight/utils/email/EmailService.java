package com.fsoft.happflight.utils.email;

import com.fsoft.happflight.dto.hoa_don.HoaDonDTO;
import com.fsoft.happflight.entities.hoa_don.HoaDon;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(EmailDetail emailDetail);

    void sendResetEmail(String email, String resetToken);

    void sendPaymentMail(HoaDon hoaDon) throws MessagingException;

    void sendPaymentMail(String email) throws MessagingException;

}
