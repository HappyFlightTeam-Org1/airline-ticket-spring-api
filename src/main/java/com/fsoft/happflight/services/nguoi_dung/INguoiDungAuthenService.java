package com.fsoft.happflight.services.nguoi_dung;

import com.fsoft.happflight.dto.nguoi_dung.DangKyDTO;
import com.fsoft.happflight.dto.nguoi_dung.ThayDoiThongTinNguoiDungDTO;
import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;

/**
 * Service interface for NguoiDungAuthen
 */
public interface INguoiDungAuthenService {
    /**
     * Validate email
     * @param email String of email
     * @return true if email is not exist in database<br>
     *         false if email is exist in database
     */
    boolean validateEmail(String email);

    /**
     * Registered new user to database
     * @param dangKyDTO FormData sent from client
     */
    void saveNguoiDung(DangKyDTO dangKyDTO);

    /**
     * Save edited user to database, check whether if email is existed in database
     * @param nguoiDung String of email
     * @param thayDoiThongTinNguoiDungDTO FormData contain edit info
     * @return true if edit info is saved<br>
     *         false if edit info is not saved (duplicate email with other user)
     */
    boolean saveThayDoiNguoiDung(NguoiDung nguoiDung, ThayDoiThongTinNguoiDungDTO thayDoiThongTinNguoiDungDTO);

    /**
     * @param email String of email
     * @return username with this email
     */
    String getUsernameFromNguoiDung(String email);

    /**
     * @param username String of username
     * @return NguoiDung with this username
     */
    NguoiDung getWithUsername(String username);
}
