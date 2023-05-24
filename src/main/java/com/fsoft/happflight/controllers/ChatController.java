package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.chat.Message;
import com.fsoft.happflight.entities.dat_cho.DatCho;
import com.fsoft.happflight.entities.hanh_khach.HanhKhach;
import com.fsoft.happflight.services.chat.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/chat-box")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    IChatService iChatService;

    @MessageMapping("/message")
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReciptient(),"/queue/messages",message);
        simpMessagingTemplate.convertAndSendToUser(message.getSender(),"/queue/messages",message);
        message.getSender();
        System.out.println(message.toString());
        message.setTime(LocalDateTime.now());
        iChatService.Save(message);
        return message;
    }
    @GetMapping(value = "/user")
    public List<String> getUser(){
        List<Message> messages = iChatService.FindALL();
        Set<String> uniqueSenders = new HashSet<>();
        for (Message message : messages) {
            uniqueSenders.add(message.getSender());
        }
        List<String> senders = new ArrayList<>(uniqueSenders);

        return senders;
    }

    @GetMapping(value = "/getchat")
    public List<Message> getMessageUser(@RequestParam(name = "user") String user){

        List<Message> messages = iChatService.FindByUser(user);
        Collections.sort(messages, Comparator.comparing(Message::getTime));
        if(user==""){
            messages=null;
        }
        return messages;
    }

}
