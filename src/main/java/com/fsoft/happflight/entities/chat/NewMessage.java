package com.fsoft.happflight.entities.chat;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "new_message")

public class NewMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private int quatity;
    
    

	public NewMessage() {
		super();
	}

	public NewMessage(Long id, String user, int quatity) {
		super();
		this.id = id;
		this.user = user;
		this.quatity = quatity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
    
    
}
