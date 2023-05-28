package com.fsoft.happflight.utils.email;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

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

    /**
     * @author DuyNT58
     * @TODO gui mail sau khi thanh toan thanh cong
     * @UPDATE_DATE May 26, 2023
     * @param hoaDon
     * @throws MessagingException
     */
    void sendPaymentMail(HoaDon hoaDon) throws MessagingException;

    /**
     * @author DuyNT58
     * @TODO gui mail den chu ve sau khi huy ve
     * @UPDATE_DATE May 26, 2023
     * @param veMayBay
     * @throws MessagingException
     */
    void sendAfterCancelTicket(VeMayBay veMayBay) throws MessagingException;

}
