package com.fsoft.happflight.repositories.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.QuocTich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Contain CRUD method for quoc_tich table
 */
@Repository
public interface IQuocTichRepository extends JpaRepository<QuocTich, Long> {
}
