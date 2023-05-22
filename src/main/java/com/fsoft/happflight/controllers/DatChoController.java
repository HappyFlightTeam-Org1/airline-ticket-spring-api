package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.chuyen_bay.MayBay;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.ve_ma_bay.VeMayBay;
import com.fsoft.happflight.services.dat_cho.IDatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dat-cho")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DatChoController {

    private IDatChoService datChoService;

    @Autowired
    public DatChoController(IDatChoService datChoService) {
        this.datChoService = datChoService;
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<List<DatCho>> getListDatChoByChuyenBayId(@PathVariable("id") String id){
        List<DatCho> datChoList = datChoService.getAllByChuyenBayId(id);
        if (datChoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(datChoList,HttpStatus.OK);
    }
}