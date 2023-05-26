package com.fsoft.happflight.utils.email;

/**
 * Service interface for email
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
}
