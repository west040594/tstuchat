package com.tstu.chatapp.exceptions;

import javax.ws.rs.NotFoundException;

public class MessageNotFoundException extends NotFoundException {
    
    public MessageNotFoundException() {
        super();
    }

    public MessageNotFoundException(String message) {
        super(message);
    }
}
