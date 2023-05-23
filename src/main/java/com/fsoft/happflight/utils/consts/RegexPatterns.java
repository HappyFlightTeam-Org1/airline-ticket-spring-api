package com.fsoft.happflight.utils.consts;

public class RegexPatterns {
    public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String TEN_TAI_KHOAN_PATTERN = "^[\\w_]{1,30}$";
    public static final String SO_DIEN_THOAI_PATTERN = "^0[\\d]{9}$";
    public static final String GIOI_TINH_PATTERN = "^(?:Nam|Nữ)$";
    public static final String HO_TEN_PATTERN = "^[\\p{L} ]{1,50}$";
    public static final String NGAY_SINH_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    public static final String HO_CHIEU_PATTERN = "^((\\d{9})|(\\d{12}))$";
    public static final String DIA_CHI_PATTERN = "^[\\p{L} \\d,]+$";
}
