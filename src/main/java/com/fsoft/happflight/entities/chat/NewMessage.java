package com.fsoft.happflight.entities.chat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "new_message")
@Data
@Getter
@Setter
public class NewMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private int quatity;
}
