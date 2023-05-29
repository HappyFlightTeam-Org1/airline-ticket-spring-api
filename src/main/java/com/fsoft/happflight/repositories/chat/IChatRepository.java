package com.fsoft.happflight.repositories.chat;

import com.fsoft.happflight.entities.chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChatRepository extends JpaRepository<Message,Long> {
    @Query(value = "SELECT * FROM chat WHERE sender = ?1 or reciptient = ?1", nativeQuery = true)
    List<Message> findByUser(String user);


}
