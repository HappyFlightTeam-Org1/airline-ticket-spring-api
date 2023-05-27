package com.fsoft.happflight.utils.email;

import com.fsoft.happflight.dto.hoa_don.HoaDonDTO;
import com.fsoft.happflight.entities.hoa_don.HoaDon;

import javax.mail.MessagingException;

public interface EmailService {
    /**
     * Basic send email function with from, to, header set
     * @param emailDetail email data
     */
    void sendEmail(EmailDetail emailDetail);

    /**
     * Send reset email to email address
     * @param email String of email
     * @param resetToken String of reset token
     */
    void sendResetEmail(String email, String resetToken);

    void sendPaymentMail(HoaDon hoaDon) throws MessagingException;

    void sendPaymentMail(String email) throws MessagingException;

}
