package com.fsoft.happflight.services.chat.impl;

import com.fsoft.happflight.entities.chat.NewMessage;
import com.fsoft.happflight.repositories.chat.INewMassageRepository;
import com.fsoft.happflight.services.chat.INewMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NewMessageImpl implements INewMassageService {

    @Autowired
    INewMassageRepository iNewMassageRepository;

    @Override
    public List<NewMessage> findAll() {
        return iNewMassageRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteNewMessageByName(String user) {
        iNewMassageRepository.deleteByUser(user);
        System.out.println("Day la xoa user"+user);
    }

    @Override
    public void save(NewMessage newMessage) {
        iNewMassageRepository.save(newMessage);
    }


    @Override
    public List<NewMessage> findByUserContainingIgnoreCase(String user) {
        return iNewMassageRepository.findByUserContainingIgnoreCase(user);
    }

    @Override
    @Transactional
    public void delete(NewMessage newMessage) {
        iNewMassageRepository.delete(newMessage);
    }
}
