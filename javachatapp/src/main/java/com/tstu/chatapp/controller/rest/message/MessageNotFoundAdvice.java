package com.tstu.chatapp.controller.rest.message;

import com.tstu.chatapp.exceptions.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class MessageNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MessageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String MessageNotFoundHandler(MessageNotFoundException e) {
        return e.getMessage();
    }
}
