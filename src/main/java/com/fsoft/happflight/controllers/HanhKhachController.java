package com.fsoft.happflight.controllers;

import com.fsoft.happflight.dto.hanh_khach.HanhKhachDTO;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.services.hanh_khach.IHanhKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/hanh-khach")
public class HanhKhachController {
    @Autowired
    private IHanhKhachService hanhKhachService;

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:51:52 PM
     * @Return: ResponseEntity<List < HanhKhach>>
     */
    @GetMapping("/list")
    public ResponseEntity<List<HanhKhach>> listHanhKhach() {
        List<HanhKhach> hanhKhachs = hanhKhachService.findAll();
        return new ResponseEntity<>(hanhKhachs, HttpStatus.OK);

    }

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:51:49 PM
     * @Return: Page<HanhKhach>
     */
    @GetMapping("/list-with-page")
    public Page<HanhKhach> getAllHanhKhach(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return hanhKhachService.findWithPageAble(pageable);
    }


    /**
     * @param hanhKhachDTOs the hanh khach DTos
     * @return the response entity
     * @function Save Hanh Khach
     * @create DucNH66
     */
    @PostMapping("/save")
    public ResponseEntity<String> saveHanhKhach(@RequestBody List<HanhKhachDTO> hanhKhachDTOs) {
        try {
            hanhKhachService.saveHanhKhach(hanhKhachDTOs);
            return ResponseEntity.ok("Lưu hành khách thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lưu hành khách thất bại");
        }

    }


    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:51:41 PM
     * @Return: Page<HanhKhach>
     */
    @GetMapping("/search")
    public Page<HanhKhach> FindListHanhKhachByName(
            @RequestParam(name = "tenHanhKhach") String tenHanhKhach, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HanhKhach> hanhKhachList;
        if (!"".equals(tenHanhKhach)) {
            hanhKhachList = hanhKhachService.findByName(pageable, tenHanhKhach);
        } else {
            hanhKhachList = hanhKhachService.findWithPageAble(pageable);
        }
        return hanhKhachList;
    }


    /**
     * @param hanhKhachDTOs the hanh khach DTos
     * @return the response entity
     * @function Save Hanh Khach
     * @create DucNH66
     */
    @PostMapping("/validate")
    public ResponseEntity<?> valiDateHanhKhach(@RequestBody List<HanhKhachDTO> hanhKhachDTOs, BindingResult bindingResult) {
        try {
            System.out.println("BEFORE");
            HanhKhachDTO hanhKhachDTO = new HanhKhachDTO("nguyen an a", "2023-06-22", "Nam", "Người Lớn");
//            for (int i = 0; i < hanhKhachDTOs.size(); i++) {
//                hanhKhachDTO = hanhKhachDTOs.get(i);
//                System.out.println(hanhKhachDTO.toString());
//            }
            new HanhKhachDTO().validate(hanhKhachDTO, bindingResult);
            System.out.println("AFTER");
//            for (HanhKhachDTO hanhHhachDTO : hanhKhachDTOs) {
//                hanhKhachValidator.validate(hanhHhachDTO, bindingResult);
//            }
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                Map<String, String> errorList = new LinkedHashMap<>();
                for (FieldError item : errors) {
                    String field = item.getField();
                    String msg = item.getDefaultMessage();
                    errorList.put(field, msg);
                }
                return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok("Validate OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lưu hành khách thất bại");
        }

    }
}
