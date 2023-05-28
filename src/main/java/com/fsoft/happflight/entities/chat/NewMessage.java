package com.fsoft.happflight.entities.chat;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "new_message")
@Data
public class NewMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private int quatity;
}
