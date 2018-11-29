package com.tstu.chatapp.controller.web;

import com.tstu.chatapp.dto.user.RegisterForm;
import com.tstu.chatapp.entity.User;
import com.tstu.chatapp.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;
    private ModelMapper modelMapper;

    public RegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "registration";
    }

    @PostMapping
    public String processRegistration(
            @ModelAttribute("registerForm") @Valid RegisterForm registerForm,
            BindingResult result)  {
        if(result.hasErrors()) {
            return "registration";
        } else {
            userService.register(modelMapper.map(registerForm, User.class));
            return "redirect:/login";
        }
    }

}
