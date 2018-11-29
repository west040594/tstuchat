package com.tstu.chatapp.service.user;

import com.tstu.chatapp.entity.User;

public interface UserService {
    User register(User user);
    User findUserByUsername(String username);
}
