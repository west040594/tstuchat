package com.tstu.chatapp.repository;

import com.tstu.chatapp.entity.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChat_Id(Long chatId);
    List<Message> findFirst20ByChat_idOrderByCreatedDateDesc(Long chatId);
}
