package com.fsoft.happflight.utils.email;

import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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

    /**
     * @author DuyNT58
     * @TODO gui mail sau khi thanh toan hoa don thanh con
     * @UPDATE_DATE May 26, 2023
     * @param hoaDon
     * @throws MessagingException
     */
    @Override
    public void sendPaymentMail(HoaDon hoaDon) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message , multipart , "utf-8");
        String htmlMsg = "<div style=\"background: url('https://images2.alphacoders.com/401/thumb-1920-40102.jpg') white; background-size: 100% 100%; background-position:right; min-height: 800px; background-repeat: no-repeat;\">" +
                "<p>Kính gửi <b>" + hoaDon.getNguoiDung().getEmail() + "</b>,</p>\n" +
                "<p>Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi. HappyFlight gửi bạn hoá đơn đã thanh toán.</p>\n" +
                "<p>Xin vui lòng kiểm tra thông tin bên dưới. Mọi thắc mắc vui lòng liên hệ số điện thoại: 0917.579.123 (Mr. Duy - Kế toán trưởng).</p>\n" +
                "<table class=\"table\" style=\"border: 1px solid; padding: 10px 10px; border-collapse: collapse;\">\n" +
                "  <thead>\n" +
                "  <tr style=\"background-color: antiquewhite;\">\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Mã hoá đơn</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Tổng tiền</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Ngày thanh toán</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Người thanh toán</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Trạng thái</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Mã bưu chính</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Quốc gia</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "  <tr style=\"background-color: aliceblue;\n\">\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + hoaDon.getMaHoaDon() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + hoaDon.getTongTien() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + hoaDon.getNgayTao() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + hoaDon.getNguoiDung().getHoVaTen() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + "Đã thanh toán" + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + "560000" + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + "Viet Nam" + "</td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "</table>" +
                "<p style=\"font-size: 11px; color: blue;\"><i>Thanks and best regards</i><br>\n" +
                "_____________________________<br>\n" +
                "<i>Nguyen Thien Duy ( Mr.) - Accounting.</i><br>\n" +
                "<i>Phone: 0917.579.123.</i><br>\n" +
                "<i>Email: thienduy0195@gmail.com.</i></p>\n" +
                "</div>";
        message.setContent(htmlMsg , "text/html; charset=UTF-8");
        helper.setFrom("happyflightservices@gmail.com");
        helper.setTo(hoaDon.getNguoiDung().getEmail());
        helper.setSubject("THANH TOÁN THÀNH CÔNG!");
        this.javaMailSender.send(message);
    }

    /**
     * @author DuyNT58
     * @TODO gui mail sau khi huy ve
     * @UPDATE_DATE May 26, 2023
     * @param veMayBay
     * @throws MessagingException
     */
    @Override
    public void sendAfterCancelTicket(VeMayBay veMayBay) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(message , multipart , "utf-8");
        String htmlMsg = "<div style=\"background: url('https://images2.alphacoders.com/401/thumb-1920-40102.jpg') white; background-size: 100% 100%; background-position:right; min-height: 800px; background-repeat: no-repeat;\">" +
                "<p>Kính gửi quý khách <b>" + veMayBay.getHoaDon().getNguoiDung().getEmail() + "</b>,</p>\n" +
                "<p>Chúng tôi thông báo đã hủy vé của bạn.</p>\n" +
                "<p>Xin vui lòng kiểm tra thông tin bên vé dưới. Mọi thắc mắc vui lòng liên hệ số điện thoại: 0917.579.123 (Mr. Duy - Nhân viên đại lý Happy Flight).</p>\n" +
                "<table class=\"table\" style=\"border: 1px solid; padding: 10px 10px; border-collapse: collapse;\">\n" +
                "  <thead>\n" +
                "  <tr style=\"background-color: antiquewhite;\">\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Mã vé</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Hạng vé</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Giá vé</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Hành khách</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Mã bưu chính</th>\n" +
                "    <th style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">Quốc gia</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "  <tr style=\"background-color: aliceblue;\n\">\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + veMayBay.getMaVe() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + veMayBay.getDatCho().getGhe().getLoaiGhe().getTenLoaiGhe() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + veMayBay.getDatCho().getChuyenBay().getGiaVe().toString() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + veMayBay.getHanhKhach().getTenHanhKhach() + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + "560000" + "</td>\n" +
                "    <td style=\"text-align: center !important; border: 1px solid; padding: 5px 5px;\">" + "Viet Nam" + "</td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "</table>" +
                "<p style=\"font-size: 11px; color: blue;\"><i>Thanks and best regards</i><br>\n" +
                "_____________________________<br>\n" +
                "<i>Nguyen Thien Duy ( Mr.) - Staff.</i><br>\n" +
                "<i>Phone: 0917.579.123.</i><br>\n" +
                "<i>Email: thienduy0195@gmail.com.</i></p>\n" +
                "</div>";
        message.setContent(htmlMsg , "text/html; charset=UTF-8");
        helper.setFrom("happyflightservices@gmail.com");
        helper.setTo(veMayBay.getHoaDon().getNguoiDung().getEmail());
        helper.setSubject("THANH TOÁN THÀNH CÔNG!");
        this.javaMailSender.send(message);
    }
}
