package com.onrcnk.citysports.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping({"", "/"})
    public String login(){

        return "userlogin";
    }

    @RequestMapping("/usersingup")
    public String singUp(){

        return "usersignup";
    }
}
