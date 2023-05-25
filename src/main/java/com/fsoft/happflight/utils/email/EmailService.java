package com.fsoft.happflight.utils.email;

public interface EmailService {
    void sendEmail(EmailDetail emailDetail);

    void sendResetEmail(String email, String resetToken);
}
