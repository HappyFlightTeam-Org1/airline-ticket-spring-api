package com.fsoft.happflight.services.hanh_khach;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHanhKhachService {
	
	/**
	 * @Author: DuyenTTM7
	 * @Day: May 26, 2023 | @Time: 7:54:42 PM
	 * @Return: List<HanhKhach>
	 */
	List<HanhKhach> findAll();
    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:54:40 PM
     * @Return: HanhKhach
     */
    HanhKhach saveHanhKhach(HanhKhach hanhKhach);

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:54:38 PM
     * @Return: void
     */
    void saveHanhKhach(List<HanhKhachDTO> hanhKhachDTOs);

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:54:34 PM
     * @Return: Page<HanhKhach>
     */
    Page<HanhKhach> findByName(Pageable pageable,String name);

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:54:32 PM
     * @Return: Page<HanhKhach>
     */
    Page<HanhKhach> findWithPageAble(Pageable pageable);
    
    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:54:30 PM
     * @Return: int
     */
    int soLuongKhachHangThangNay();
}
