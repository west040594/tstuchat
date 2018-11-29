package com.tstu.chatapp.dto.chat;

import com.tstu.chatapp.dto.user.UserDto;
import com.tstu.chatapp.enums.ChatType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChatForm {
    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private ChatType type;
    private UserDto user;
}
