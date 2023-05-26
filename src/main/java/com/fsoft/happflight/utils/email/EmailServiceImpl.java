package com.fsoft.happflight.utils.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(EmailDetail emailDetail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("noreply@happyflight.com");
            mailMessage.setTo(emailDetail.getRecipent());
            mailMessage.setText(emailDetail.getMessageBody());
            mailMessage.setSubject(emailDetail.getSubject());
            javaMailSender.send(mailMessage);
            System.out.println("Gửi email thành công");
        }
        catch (Exception e) {
            System.out.println("Có lỗi khi gửi email");
        }
    }

    @Override
    public void sendResetEmail(String email, String resetToken) {
        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setRecipent(email);
        emailDetail.setSubject("Email đặt lại mật khẩu");
        emailDetail.setMessageBody("URL đặt lại mật khẩu:\n\n"
                + "http://localhost:3000/ThietLapMatKhauMoi?reset-token=" + resetToken +
                "\n\n*Lưu ý*: URL chỉ có hiệu lực trong 10 phút.");
        sendEmail(emailDetail);
    }
}
