package com.tstu.chatapp.exceptions;

import javax.ws.rs.NotFoundException;

public class ChatNotFoundException extends NotFoundException {

    public ChatNotFoundException() {
        super();
    }

    public ChatNotFoundException(String message) {
        super(message);
    }
}
