package com.fsoft.happflight.services.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.QuocTich;

import java.util.List;

/**
 * Service interface for QuocTichService
 */
public interface IQuocTichService {
    /**
     * @param id primary key of a QuocTich row
     * @return QuocTich object with this id
     */
    QuocTich getById(int id);

    /**
     * Get all Quoc Tich in database
     * @return list of Quoc Tich
     */
    List<QuocTich> getAll();
}
