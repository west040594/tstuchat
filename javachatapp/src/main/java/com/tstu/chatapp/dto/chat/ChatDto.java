package com.tstu.chatapp.dto.chat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tstu.chatapp.dto.user.UserDto;
import com.tstu.chatapp.enums.ChatStatus;
import com.tstu.chatapp.enums.ChatType;
import lombok.Data;

import java.util.Date;

@Data
public class ChatDto {
    private Long id;
    private String name;
    private String description;
    private ChatType type;
    private ChatStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date closedDate;
    private UserDto user;
}
