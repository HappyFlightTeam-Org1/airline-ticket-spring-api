package com.fsoft.happflight.services.chat;

import com.fsoft.happflight.entities.chat.Message;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IChatService {
    void Save(Message message);
    List<Message> FindALL();

    List<Message> FindByUser(String user);

}
