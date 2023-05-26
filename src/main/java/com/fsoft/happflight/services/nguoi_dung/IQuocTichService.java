package com.fsoft.happflight.services.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.QuocTich;

import java.util.List;

public interface IQuocTichService {
    QuocTich getById(int id);

    List<QuocTich> getAll();
}
