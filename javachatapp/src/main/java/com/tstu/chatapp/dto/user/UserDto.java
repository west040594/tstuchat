package com.tstu.chatapp.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tstu.chatapp.enums.UserRole;
import com.tstu.chatapp.enums.UserStatus;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
    private UserStatus status;
    private Date createdDate;
}
