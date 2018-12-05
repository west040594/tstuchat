package com.tstu.chatapp.service.message;

import com.tstu.chatapp.entity.Message;
import com.tstu.chatapp.exceptions.MessageNotFoundException;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MessageService {
    Message findMessageById(Long id) throws MessageNotFoundException;
    List<Message> findMessagesByChatId(Long chatId);
    List<Message> findAllMessages();
    List<Message> findAllMessages(PageRequest pageRequest);
    Message saveMessage(Message message);
    void deleteMessageById(Long id);
}
