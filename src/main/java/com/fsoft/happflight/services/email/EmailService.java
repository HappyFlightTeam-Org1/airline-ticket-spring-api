package com.fsoft.happflight.services.email;

import com.fsoft.happflight.dto.email.CancelEmailDTO;
import com.fsoft.happflight.dto.email.PaymentEmailDTO;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.utils.email.EmailDetail;

import javax.mail.MessagingException;

/**
 * EmailService
 * Version: 2.0
 * @DATE May 30, 2023
 * Copyright
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * May 30, 2023         DuyNT58          update code
 */
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
     * @TODO Gui email sau khi thanh toan thanh cong
     * @param paymentEmailDTO
     * @throws MessagingException
     */
    void sendPaymentMail(PaymentEmailDTO paymentEmailDTO) throws MessagingException;

  
    /**
     * @TODO Gui email toi nguoi dung sau khi huy ve thanh cong
     * @param cancelEmailDTO
     * @throws MessagingException
     */
    void sendAfterCancelTicket(CancelEmailDTO cancelEmailDTO) throws MessagingException;

}
