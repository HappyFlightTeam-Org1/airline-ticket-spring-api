package com.fsoft.happflight.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.services.dat_cho.IDatChoService;

/**
 * @author DuyNT58
 * @UPDATE_DATE May 26, 2023
 */
@RestController
@RequestMapping(value = "/dat-cho")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DatChoController {

    private IDatChoService datChoService;

    @Autowired
    public DatChoController(IDatChoService datChoService) {
        this.datChoService = datChoService;
    }

    /**
     * @author DuyNT58
     * @TODO
     * @UPDATE_DATE May 26, 2023
     * @param id
     * @return List<DatCho>
     */
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<List<DatCho>> getListDatChoByChuyenBayId(@PathVariable("id") String id){
        List<DatCho> datChoList = datChoService.getAllByChuyenBayId(id);
        if (datChoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(datChoList,HttpStatus.OK);
    }
}
