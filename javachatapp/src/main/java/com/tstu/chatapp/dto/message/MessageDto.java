package com.tstu.chatapp.dto.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tstu.chatapp.dto.user.UserDto;
import com.tstu.chatapp.dto.chat.ChatDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
public class MessageDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    @NotNull
    private UserDto user;
    @NotNull
    private ChatDto chat;


}
