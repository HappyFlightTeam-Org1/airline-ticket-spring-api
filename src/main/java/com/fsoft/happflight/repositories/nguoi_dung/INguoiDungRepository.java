package com.fsoft.happflight.repositories.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface INguoiDungRepository extends JpaRepository<NguoiDung, String> {
}
