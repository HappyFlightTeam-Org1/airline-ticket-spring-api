package com.fsoft.happflight.dto.ve_may_bay;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.hoa_don.HoaDonDTO;

import java.util.List;

public class VeMayBayDTO {
    private HoaDonDTO hoaDonDTO;
    private Long[] maDatChos;
    private List<HanhKhachDTO> hanhKhachDTOs;

    public VeMayBayDTO() {
    }

    public VeMayBayDTO(HoaDonDTO hoaDonDTO, Long[] maDatChos, List<HanhKhachDTO> hanhKhachDTOs) {
        this.hoaDonDTO = hoaDonDTO;
        this.maDatChos = maDatChos;
        this.hanhKhachDTOs = hanhKhachDTOs;
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

    public Long[] getMaDatChos() {
        return maDatChos;
    }

    public void setMaDatChos(Long[] maDatChos) {
        this.maDatChos = maDatChos;
    }

    @Override
    public String toString() {
        return "VeMayBayDTO{" +
                "hoaDonDTO=" + hoaDonDTO +
                ", maDatChos=" + maDatChos +
                ", hanhKhachDTOs=" + hanhKhachDTOs +
                '}';
    }
}
