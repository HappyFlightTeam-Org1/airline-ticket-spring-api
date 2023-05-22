package com.fsoft.happflight.dto.ve_may_bay;

import com.fsoft.happflight.dto.dat_cho.DatChoDTO;
import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.dto.hoa_don.HoaDonDTO;

import java.util.List;

public class VeMayBayDTO {
    private HoaDonDTO hoaDonDTO;
    private List<DatChoDTO> datChoDTOs;
    private List<HanhKhachDTO> hanhKhachDTOs;

    public VeMayBayDTO() {
    }

    public VeMayBayDTO(HoaDonDTO hoaDonDTO, List<DatChoDTO> datChoDTOs, List<HanhKhachDTO> hanhKhachDTOs) {
        this.hoaDonDTO = hoaDonDTO;
        this.datChoDTOs = datChoDTOs;
        this.hanhKhachDTOs = hanhKhachDTOs;
    }

    public HoaDonDTO getHoaDonDTO() {
        return hoaDonDTO;
    }

    public void setHoaDonDTO(HoaDonDTO hoaDonDTO) {
        this.hoaDonDTO = hoaDonDTO;
    }

    public List<DatChoDTO> getDatChoDTOs() {
        return datChoDTOs;
    }

    public void setDatChoDTOs(List<DatChoDTO> datChoDTOs) {
        this.datChoDTOs = datChoDTOs;
    }

    public List<HanhKhachDTO> getHanhKhachDTOs() {
        return hanhKhachDTOs;
    }

    public void setHanhKhachDTOs(List<HanhKhachDTO> hanhKhachDTOs) {
        this.hanhKhachDTOs = hanhKhachDTOs;
    }
}
