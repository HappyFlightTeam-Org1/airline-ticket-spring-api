package com.fsoft.happflight.services.chat.impl;

import com.fsoft.happflight.entities.chat.Message;
import com.fsoft.happflight.repositories.chat.IChatRepository;
import com.fsoft.happflight.services.chat.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements IChatService {

    @Autowired
    IChatRepository iChatRepository;
    @Override
    public void Save(Message message) {
        iChatRepository.save(message);
    }

    @Override
    public List<Message> FindALL() {
       return iChatRepository.findAll();
    }

    @Override
    public List<Message> FindByUser(String user) {
        return iChatRepository.findByUser(user);
    }



}
