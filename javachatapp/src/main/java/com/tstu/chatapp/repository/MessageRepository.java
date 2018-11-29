package com.tstu.chatapp.repository;

import com.tstu.chatapp.entity.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
    List<Message> findAllByChatId(Long chatId);
}
