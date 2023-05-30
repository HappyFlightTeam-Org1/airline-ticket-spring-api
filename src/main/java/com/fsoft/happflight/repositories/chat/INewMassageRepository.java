package com.fsoft.happflight.repositories.chat;

import com.fsoft.happflight.entities.chat.NewMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface INewMassageRepository extends JpaRepository<NewMessage,Long> {

    /**
     * @Author: DuyenTTM7
     * @Day: May 26, 2023 | @Time: 7:52:48 PM
     * @Return: void
     */
    @Modifying
    @Query(value = "DELETE FROM newmessage WHERE user = :user", nativeQuery = true)
    void deleteByUser(@Param("user") String user);

    List<NewMessage> findByUserContainingIgnoreCase(String user);

}
