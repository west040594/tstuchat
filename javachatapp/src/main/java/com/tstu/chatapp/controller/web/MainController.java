package com.tstu.chatapp.controller.web;

import com.tstu.chatapp.dto.user.UserDto;
import com.tstu.chatapp.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class MainController {

    private ModelMapper modelMapper;

    public MainController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/home", "/"})
    public String homePage(Model model,
                           @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        if(user != null) {
            data.put("user", modelMapper.map(user, UserDto.class));
        }
        data.put("greentings", "Greeting Message");
        model.addAttribute("frontendData", data);
        return "home";
    }

}
