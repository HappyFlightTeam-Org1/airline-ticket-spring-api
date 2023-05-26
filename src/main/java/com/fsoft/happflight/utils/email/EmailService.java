package com.fsoft.happflight.utils.email;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(EmailDetail emailDetail);

    void sendResetEmail(String email, String resetToken);

    void sendPaymentMail(HoaDon hoaDon) throws MessagingException;

    void sendAfterCancelTicket(VeMayBay veMayBay) throws MessagingException;

}
