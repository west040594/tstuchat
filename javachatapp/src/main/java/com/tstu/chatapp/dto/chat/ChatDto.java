package com.tstu.chatapp.dto.chat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tstu.chatapp.dto.user.UserDto;
import com.tstu.chatapp.enums.ChatStatus;
import com.tstu.chatapp.enums.ChatType;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    @JsonIgnore
    public String getCreatedDateFormat() {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return newDateFormat.format(createdDate);
    }
}
