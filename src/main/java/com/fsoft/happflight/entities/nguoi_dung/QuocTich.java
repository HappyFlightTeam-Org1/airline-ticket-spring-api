package com.fsoft.happflight.entities.nguoi_dung;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuocTich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_quoc_tich")
    private Long maQuocTich;

    @Column(name = "ten_quoc_tich", columnDefinition = "nvarchar(50)")
    private String tenQuocTich;

    @OneToMany(mappedBy = "quocTich", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<NguoiDung> users;

    public QuocTich() {
        super();
        // TODO Auto-generated constructor stub
    }

    public QuocTich(Long maQuocTich, String tenQuocTich) {
        super();
        this.maQuocTich = maQuocTich;
        this.tenQuocTich = tenQuocTich;
    }

    public QuocTich(Long maQuocTich, String tenQuocTich, Set<NguoiDung> users) {
        super();
        this.maQuocTich = maQuocTich;
        this.tenQuocTich = tenQuocTich;
        this.users = users;
    }

    public Long getMaQuocTich() {
        return maQuocTich;
    }

    public void setMaQuocTich(Long maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

    public String getTenQuocTich() {
        return tenQuocTich;
    }

    public void setTenQuocTich(String tenQuocTich) {
        this.tenQuocTich = tenQuocTich;
    }

    public Set<NguoiDung> getUsers() {
        return users;
    }

    public void setUsers(Set<NguoiDung> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "QuocTich [maQuocTich=" + maQuocTich + ", tenQuocTich=" + tenQuocTich + "]";
    }

}

