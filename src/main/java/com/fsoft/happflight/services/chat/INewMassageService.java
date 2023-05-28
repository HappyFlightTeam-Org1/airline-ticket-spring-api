package com.fsoft.happflight.services.chat;

import com.fsoft.happflight.entities.chat.NewMessage;

import java.util.List;

public interface INewMassageService {
    List<NewMessage> findAll();
    void deleteNewMessageByName(String user);
    void save(NewMessage newMessage);

    List<NewMessage> findByUserContainingIgnoreCase(String user);

    void delete(NewMessage newMessage);
}
