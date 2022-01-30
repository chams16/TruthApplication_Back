package com.chams.sarahaback.repository;

import com.chams.sarahaback.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findAllBySenderId(Integer id);
    List<Message> findAllByReceiverId(Integer id);
    Integer countBySenderId(Integer userId);
}
