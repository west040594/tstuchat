package com.tstu.chatapp.controller.rest.message;

import com.tstu.chatapp.dto.message.MessageDto;
import com.tstu.chatapp.entity.Message;
import com.tstu.chatapp.service.message.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/message")
public class MessageRestController {

    private MessageService messageService;
    private ModelMapper modelMapper;

    public MessageRestController(MessageService messageService, ModelMapper modelMapper) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MessageDto> readMessages() {
        return messageService.findAllMessages().stream()
                .map(message -> modelMapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MessageDto readMessage(@PathVariable Long id) {
        return modelMapper.map(messageService.findMessageById(id), MessageDto.class);
    }

    @PostMapping
    public MessageDto addMessage(@Valid @RequestBody MessageDto messageDto) {
        return modelMapper.map(messageService.saveMessage(
                modelMapper.map(messageDto, Message.class)
        ), MessageDto.class);
    }

    @PutMapping("{id}")
    public MessageDto editMessage(@RequestBody MessageDto newMessageDto,
                                  @PathVariable("id") MessageDto oldMessageDto)  {
        BeanUtils.copyProperties(newMessageDto, oldMessageDto, "id");
        return modelMapper.map(messageService.saveMessage(
                modelMapper.map(oldMessageDto, Message.class)
        ), MessageDto.class);
    }

    @DeleteMapping("{id}")
    public void  deleteMessage(@PathVariable Long id) {
        messageService.deleteMessageById(id);
    }


    @MessageMapping("/addMessage")
    @SendTo("/topic/chat")
    public MessageDto changeSock(@Valid @RequestBody MessageDto messageDto) throws Exception {
        return modelMapper.map(
                messageService.saveMessage(modelMapper.map(messageDto, Message.class)),
                MessageDto.class);
    }

    @MessageMapping("/deleteMessage")
    @SendTo("/topic/chat")
    public MessageDto deleteSock(Long id) {
        MessageDto deletedMessage = modelMapper.map(messageService.findMessageById(id), MessageDto.class);
        messageService.deleteMessageById(id);
        return deletedMessage;
    }

}
