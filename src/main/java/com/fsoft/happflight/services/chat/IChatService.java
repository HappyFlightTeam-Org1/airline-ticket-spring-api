package com.fsoft.happflight.services.chat;

import com.fsoft.happflight.entities.chat.Message;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IChatService {
    void Save(Message message);
    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:42 PM
     * @Return: List<Message>
     */
    List<Message> FindALL();

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:44 PM
     * @Return: List<Message>
     */
    List<Message> FindByUser(String user);

}
