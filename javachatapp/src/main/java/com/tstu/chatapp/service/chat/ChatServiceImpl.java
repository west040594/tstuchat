package com.tstu.chatapp.service.chat;

import com.tstu.chatapp.entity.Chat;
import com.tstu.chatapp.enums.ChatStatus;
import com.tstu.chatapp.enums.ChatType;
import com.tstu.chatapp.exceptions.ChatNotFoundException;
import com.tstu.chatapp.repository.ChatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {
    private ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat findChatById(Long id) throws ChatNotFoundException {
        return chatRepository.findById(id).orElseThrow(() -> new ChatNotFoundException("Chat not found"));
    }

    @Override
    public List<Chat> findAllActiveChats() {
        return chatRepository.findAllByStatusAndType(ChatStatus.ACTIVE, ChatType.PUBLIC);
    }

    @Override
    public Chat saveChat(Chat chat) {
        log.info("New chat with name: {}. Saved", chat.getName());
        chat.setCreatedDate(new Date());
        chat.setStatus(ChatStatus.ACTIVE);
        return chatRepository.save(chat);
    }

    @Override
    public void deleteChatById(Long id) {
        log.info("Chat with id: {}. Deleted", id);
        chatRepository.deleteById(id);
    }
}
