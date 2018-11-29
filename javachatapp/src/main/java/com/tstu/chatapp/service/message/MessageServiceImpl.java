package com.tstu.chatapp.service.message;

import com.tstu.chatapp.entity.Message;
import com.tstu.chatapp.exceptions.MessageNotFoundException;
import com.tstu.chatapp.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private MessagePublisher messagePublisher;

    public MessageServiceImpl(MessageRepository messageRepository, MessagePublisher messagePublisher) {
        this.messageRepository = messageRepository;
        this.messagePublisher = messagePublisher;
    }

    @Override
    public Message findMessageById(Long id) throws MessageNotFoundException {
        return messageRepository.findById(id).orElseThrow(() -> new MessageNotFoundException("Message Not Found"));
    }

    @Override
    public List<Message> findMessagesByChatId(Long chatId) {
        return messageRepository.findAllByChatId(chatId);
    }

    @Override
    public List<Message> findAllMessages() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public Message saveMessage(Message message) {
        message.setCreatedDate(new Date());
        message =  messageRepository.save(message);
        messagePublisher.publish(message);
        log.info("Message {} saved", message.getText());
        return message;
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }
}
