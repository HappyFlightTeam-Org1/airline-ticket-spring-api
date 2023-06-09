package com.fsoft.happflight.entities.tai_khoan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.fsoft.happflight.utils.taikhoan_role_enum.TaiKhoanRole;


/**
 * Role
 * Version: 2.0
 * @DATE May 26, 2023
 * Copyright
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * May 30, 2023         DuyNT58          update code
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "role_name", length = 60)
    private TaiKhoanRole name;

    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Role(Long id, TaiKhoanRole name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaiKhoanRole getName() {
        return name;
    }

    public void setName(TaiKhoanRole name) {
        this.name = name;
    }

}

