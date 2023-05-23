package com.fsoft.happflight.repositories.nguoi_dung;

import com.fsoft.happflight.entities.nguoi_dung.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface INguoiDungAuthenRepository extends JpaRepository<NguoiDung, String> {
    @Query(value = "SELECT * FROM nguoi_dung WHERE email=:email", nativeQuery = true)
    NguoiDung getNguoiDungByEmail(@Param("email") String email);
}
