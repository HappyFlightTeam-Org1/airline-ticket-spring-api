package com.fsoft.happflight.services.chat;

import com.fsoft.happflight.entities.chat.NewMessage;

import java.util.List;

public interface INewMassageService {
    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:48 PM
     * @Return: List<NewMessage>
     */
    List<NewMessage> findAll();
    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:51 PM
     * @Return: void
     */
    void deleteNewMessageByName(String user);
    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:53 PM
     * @Return: void
     */
    void save(NewMessage newMessage);

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:53:55 PM
     * @Return: List<NewMessage>
     */
    List<NewMessage> findByUserContainingIgnoreCase(String user);

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:54:00 PM
     * @Return: void
     */
    void delete(NewMessage newMessage);
}
