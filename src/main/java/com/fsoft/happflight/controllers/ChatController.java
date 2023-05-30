package com.fsoft.happflight.controllers;

import com.fsoft.happflight.entities.chat.Message;
import com.fsoft.happflight.entities.chat.NewMessage;
import com.fsoft.happflight.services.chat.IChatService;
import com.fsoft.happflight.services.chat.INewMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;



@RestController
@CrossOrigin("*")
@RequestMapping("/chat-box")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    IChatService iChatService;

    @Autowired
    INewMassageService iNewMassageService;

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:50:13 PM
     * @Return: Message
     */
    @MessageMapping("/message")
    public Message recMessage(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReciptient(), "/queue/messages", message);
        simpMessagingTemplate.convertAndSendToUser(message.getSender(), "/queue/messages", message);
        message.getSender();
        System.out.println(message.toString());
        message.setTime(LocalDateTime.now());
        iChatService.Save(message);
        return message;
    }

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:50:10 PM
     * @Return: List<String>
     */
    @GetMapping(value = "/user")
    public List<String> getUser() {
        List<Message> messages = iChatService.FindALL();
        Collections.sort(messages, Comparator.comparing(Message::getTime));
        System.out.println(messages);
        Collections.reverse(messages);
        Set<String> uniqueSenders = new LinkedHashSet<>();
        for (Message message : messages) {
            uniqueSenders.add(message.getSender());
        }
        List<String> senders = new ArrayList<>(uniqueSenders);
        System.out.println(senders);
        return senders;
    }

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:50:05 PM
     * @Return: List<NewMessage>
     */
    @GetMapping(value = "/new-message")
    public List<NewMessage> getAllNewMessage() {
        List<NewMessage> users = iNewMassageService.findAll();
        System.out.println(users);
        return users;
    }

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:50:02 PM
     * @Return: ResponseEntity<String>
     */
    @DeleteMapping(value = "/delete-new-message/{user}")
    public ResponseEntity<String> deleteNewMessage(@PathVariable String user) {
        List<NewMessage> messages = iNewMassageService.findByUserContainingIgnoreCase(user);
        if (null != messages) {
            for (NewMessage message : messages) {
                iNewMassageService.delete(message);
            }
        } else {
            System.out.println("Null roi");
        }
        String messageOk = "Đã xóa user: " + user;
        return ResponseEntity.ok().body(messageOk);
    }

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:49:58 PM
     * @Return: ResponseEntity<String>
     */
    @GetMapping(value = "/save-new-message/{user}")
    public ResponseEntity<String> saveNewMessage(@PathVariable String user) {
        boolean check = true;
        List<NewMessage> newMessages = iNewMassageService.findAll();
        System.out.println(newMessages);
        for (NewMessage message : newMessages) {
            if (message.getUser().equals(user)) {
                int k = message.getQuatity();
                System.out.println(k);
                message.setQuatity(k+1);
                iNewMassageService.save(message);
                check = false;
                break;
            }
        }
        if (check) {
            NewMessage newMessage = new NewMessage();
            newMessage.setUser(user);
            newMessage.setQuatity(1);
            iNewMassageService.save(newMessage);
        }
        String messageOk = "Đã theem user: " + user;
        return ResponseEntity.ok().body(messageOk);
    }


    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:49:55 PM
     * @Return: List<Message>
     */
    @GetMapping(value = "/getchat")
    public List<Message> getMessageUser(@RequestParam(name = "user") String user) {
        List<Message> messages = iChatService.FindByUser(user);
        Collections.sort(messages, Comparator.comparing(Message::getTime));
        if (user == "") {
            messages = null;
        }
        return messages;
    }

}
