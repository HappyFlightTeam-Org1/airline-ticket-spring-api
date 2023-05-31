package com.fsoft.happflight.services.nguoi_dung.impl;

import com.fsoft.happflight.entities.nguoi_dung.QuocTich;
import com.fsoft.happflight.repositories.nguoi_dung.IQuocTichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for QuocTichService
 */
@Service
public class QuocTichServiceImpl {
    @Autowired
    private IQuocTichRepository quocTichRepository;

    public QuocTich getById(long id) {
        return quocTichRepository.getReferenceById(id);
    }

    public List<QuocTich> getAll() {
        return quocTichRepository.findAll();
    }
}
