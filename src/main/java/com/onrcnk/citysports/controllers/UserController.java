package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String getLoginPage(){
        return "user/login";
    }

    @RequestMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "user/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "/logout";
    }
}