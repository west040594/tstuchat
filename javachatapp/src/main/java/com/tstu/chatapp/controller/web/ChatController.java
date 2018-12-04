package com.tstu.chatapp.controller.web;

import com.tstu.chatapp.dto.chat.ChatDto;
import com.tstu.chatapp.dto.chat.ChatForm;
import com.tstu.chatapp.dto.message.MessageDto;
import com.tstu.chatapp.dto.user.UserDto;
import com.tstu.chatapp.entity.Chat;
import com.tstu.chatapp.entity.User;
import com.tstu.chatapp.enums.ChatType;
import com.tstu.chatapp.service.chat.ChatService;
import com.tstu.chatapp.service.message.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/chats")
public class ChatController {

    private ChatService chatService;
    private ModelMapper modelMapper;
    private MessageService messageService;

    public ChatController(ChatService chatService, MessageService messageService, ModelMapper modelMapper) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String chatListPage(Model model) {
        List<ChatDto> chatList = chatService.findAllActiveChats().stream()
                .map(chat -> modelMapper.map(chat, ChatDto.class))
                .collect(Collectors.toList());
        model.addAttribute("chatList", chatList);
        return "chatList";
    }

    @GetMapping("/{id}")
    public String chatPage(
            @PathVariable Long id,
            Model model,
            @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        ChatDto chatDto = modelMapper.map(chatService.findChatById(id), ChatDto.class);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        data.put("user", userDto );
        data.put("chat",  chatDto);
        List<MessageDto> messageDtoList = messageService.findMessagesByChatId(id).stream()
                .map(message -> modelMapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
        data.put("messages", messageDtoList);
        model.addAttribute("frontendData", data);
        return "chat";
    }

    @GetMapping("/create")
    public String chatCreateForm(Model model) {
        model.addAttribute("types", ChatType.values());
        model.addAttribute("chatForm", new ChatForm());
        return "chatCreate";
    }

    @PostMapping("/create")
    public String processChatCreate(@ModelAttribute("chatForm") @Valid ChatForm chatForm,
                                 BindingResult result, @AuthenticationPrincipal User user, Model model) {
        if(result.hasErrors()) {
            return "chatCreate";
        } else {
            chatForm.setUser(modelMapper.map(user, UserDto.class));
            Long chatId = (chatService.saveChat(modelMapper.map(chatForm, Chat.class))).getId();
            return "redirect:/chats/" + chatId;
        }
    }

    @PostMapping("/delete/{id}")
    public String processChatDelete(@PathVariable Long id,  @AuthenticationPrincipal User user) {
        if(chatService.findChatById(id).getUser().equals(user)) {
            chatService.deleteChatById(id);
            return "redirect:/chats";
        }
        return "redirect:/chats/{id}";
    }
}
