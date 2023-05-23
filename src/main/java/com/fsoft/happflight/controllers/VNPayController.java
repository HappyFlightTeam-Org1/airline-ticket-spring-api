package com.fsoft.happflight.controllers;

import com.fsoft.happflight.config.vnpay.VnpayConfig;
import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.ve_may_bay.VeMayBayDTO;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.entities.hoa_don.HoaDon;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import com.fsoft.happflight.services.hoa_don.IHoaDonService;
import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;
import com.fsoft.happflight.services.ve_may_bay.IVeMayBayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/thanh-toan")
public class VNPayController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private HttpServletResponse resp;

    @Autowired
    private INguoiDungService nguoiDungService;

    @Autowired
    private IDatChoService datChoService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IHanhKhachService hanhKhachService;

    @Autowired
    private IVeMayBayService veMayBayService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/vnpay/make-order")
    public String createPaymentVNPay(@RequestBody VeMayBayDTO veMayBayDTO) throws UnsupportedEncodingException {
        System.out.println("HERREEE");
        System.out.println(veMayBayDTO.toString());
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_OrderInfo = "Hoa don ve may bay";
        String orderType = "other";
//        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_TxnRef = veMayBayDTO.getHoaDonDTO().getMaHoaDon();
//        String vnp_IpAddr = Config.getIpAddress(req);
        String vnp_IpAddr = "118.69.35.214";
        String vnp_TmnCode = VnpayConfig.vnp_TmnCode;
        Long amount = veMayBayDTO.getHoaDonDTO().getTongTien() != null ? veMayBayDTO.getHoaDonDTO().getTongTien() * 100 : 1000000;
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = req.getParameter("bankcode");
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        } else {
            vnp_Params.put("vnp_BankCode", "");
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = req.getParameter("language");
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        System.out.println("MA DAT CHO");
        System.out.println(Arrays.toString(veMayBayDTO.getMaDatChos()));
        vnp_Params.put("vnp_ReturnUrl", VnpayConfig.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        //Add Params of 2.0.1 Version
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        //Billing
        vnp_Params.put("vnp_Bill_Mobile", req.getParameter("txt_billing_mobile"));
        vnp_Params.put("vnp_Bill_Email", req.getParameter("txt_billing_email"));

        vnp_Params.put("vnp_Bill_Address", req.getParameter("txt_inv_addr1"));
        vnp_Params.put("vnp_Bill_City", req.getParameter("txt_bill_city"));
        vnp_Params.put("vnp_Bill_Country", req.getParameter("txt_bill_country"));
        if (req.getParameter("txt_bill_state") != null && !req.getParameter("txt_bill_state").isEmpty()) {
            vnp_Params.put("vnp_Bill_State", req.getParameter("txt_bill_state"));
        }

        // Invoice
        vnp_Params.put("vnp_Inv_Phone", req.getParameter("txt_inv_mobile"));
        vnp_Params.put("vnp_Inv_Email", req.getParameter("txt_inv_email"));
        vnp_Params.put("vnp_Inv_Customer", req.getParameter("txt_inv_customer"));
        vnp_Params.put("vnp_Inv_Address", req.getParameter("txt_inv_addr1"));
        vnp_Params.put("vnp_Inv_Company", req.getParameter("txt_inv_company"));
        vnp_Params.put("vnp_Inv_Taxcode", req.getParameter("txt_inv_taxcode"));
        vnp_Params.put("vnp_Inv_Type", req.getParameter("cbo_inv_type"));
        //Build data to hash and querystring
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }

        //thêm mới hóa đơn
        NguoiDung nguoiDung = nguoiDungService.findById(veMayBayDTO.getHoaDonDTO().getEmailNguoiDung());
        System.out.println(nguoiDung.toString());
        HoaDon hoaDon = modelMapper.map(veMayBayDTO.getHoaDonDTO(), HoaDon.class);
        hoaDon.setNguoiDung(nguoiDung);
        System.out.println("HOA DON1230" + hoaDon.toString());
        HoaDon hoaDon1 = hoaDonService.create(hoaDon);

        List<Long> maDatChos = Arrays.asList(veMayBayDTO.getMaDatChos());
        List<HanhKhachDTO> hanhKhachDTOS = veMayBayDTO.getHanhKhachDTOs();
        for (int i = 0; i < maDatChos.size(); i++) {
            for (int j = 0; j < hanhKhachDTOS.size(); j++) {
                DatCho datCho = datChoService.findById(maDatChos.get(i));
                String maVe = "TK" + datCho.getGhe().getTenGhe() + datCho.getChuyenBay().getMaChuyenBay() + datCho.getMaDatCho();
                String hangVe = datCho.getGhe().getLoaiGhe().getTenLoaiGhe();
                Long giaVe = datCho.getChuyenBay().getGiaVe();
                HanhKhach hanhKhach = modelMapper.map(hanhKhachDTOS.get(j), HanhKhach.class);
                HanhKhach hanhKhach1 = hanhKhachService.saveHanhKhach(hanhKhach);
                veMayBayService.create(new VeMayBay(maVe, hangVe, giaVe, 0, hanhKhach1, datCho, hoaDon1));
            }


        }

        String queryUrl = query.toString();
        String vnp_SecureHash = VnpayConfig.hmacSHA512(VnpayConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VnpayConfig.vnp_PayUrl + "?" + queryUrl;
        return paymentUrl;
    }
}
