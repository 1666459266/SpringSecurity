package com.core.securityspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyLoginController {
    @RequestMapping("/login_view")
    public String login_view(){
        return "login";
    }

    @RequestMapping("/login_view/logout")
    public String login_view_logout(){
        return "login";
    }
}
