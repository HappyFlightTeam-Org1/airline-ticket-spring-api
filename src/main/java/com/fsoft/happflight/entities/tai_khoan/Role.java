package com.fsoft.happflight.entities.tai_khoan;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

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

