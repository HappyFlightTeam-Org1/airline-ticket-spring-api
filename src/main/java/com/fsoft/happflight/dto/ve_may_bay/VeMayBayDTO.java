package com.fsoft.happflight.dto.ve_may_bay;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.hoa_don.HoaDonDTO;

import java.util.Arrays;
import java.util.List;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
public class VeMayBayDTO {
    private HoaDonDTO hoaDonDTO;
    private List<HanhKhachDTO> hanhKhachDTOs;
    private Long[] maDatChoDis;
    private Long[] maDatChoKhuHois;

    public VeMayBayDTO() {
    }

    public VeMayBayDTO(HoaDonDTO hoaDonDTO, List<HanhKhachDTO> hanhKhachDTOs, Long[] maDatChoDis, Long[] maDatChoKhuHois) {
        this.hoaDonDTO = hoaDonDTO;
        this.hanhKhachDTOs = hanhKhachDTOs;
        this.maDatChoDis = maDatChoDis;
        this.maDatChoKhuHois = maDatChoKhuHois;
    }

    public HoaDonDTO getHoaDonDTO() {
        return hoaDonDTO;
    }

    public void setHoaDonDTO(HoaDonDTO hoaDonDTO) {
        this.hoaDonDTO = hoaDonDTO;
    }

    public List<HanhKhachDTO> getHanhKhachDTOs() {
        return hanhKhachDTOs;
    }

    public void setHanhKhachDTOs(List<HanhKhachDTO> hanhKhachDTOs) {
        this.hanhKhachDTOs = hanhKhachDTOs;
    }

    public Long[] getMaDatChoDis() {
        return maDatChoDis;
    }

    public void setMaDatChoDis(Long[] maDatChoDis) {
        this.maDatChoDis = maDatChoDis;
    }

    public Long[] getMaDatChoKhuHois() {
        return maDatChoKhuHois;
    }

    public void setMaDatChoKhuHois(Long[] maDatChoKhuHois) {
        this.maDatChoKhuHois = maDatChoKhuHois;
    }

    @Override
    public String toString() {
        return "VeMayBayDTO{" +
                "hoaDonDTO=" + hoaDonDTO +
                ", hanhKhachDTOs=" + hanhKhachDTOs +
                ", maDatChoDis=" + Arrays.toString(maDatChoDis) +
                ", maDatChoKhuHois=" + Arrays.toString(maDatChoKhuHois) +
                '}';
    }
}
