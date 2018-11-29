package com.tstu.chatapp.repository;

import com.tstu.chatapp.entity.Chat;
import com.tstu.chatapp.enums.ChatStatus;
import com.tstu.chatapp.enums.ChatType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ChatRepository  extends CrudRepository<Chat, Long> {
    List<Chat> findAllByStatusAndType(ChatStatus status, ChatType chatType);
}

