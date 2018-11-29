package com.tstu.chatapp.service.chat;

import com.tstu.chatapp.entity.Chat;
import com.tstu.chatapp.exceptions.ChatNotFoundException;

import java.util.List;

public interface ChatService {
    Chat findChatById(Long id) throws ChatNotFoundException;
    List<Chat> findAllActiveChats();
    Chat saveChat(Chat chat);
    void deleteChatById(Long id);
}
