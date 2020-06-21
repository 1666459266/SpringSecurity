package com.core.security.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = "text/plain;charset=utf-8")
    public String loginSuccess(){
        return "登录成功";
    }

    @RequestMapping("/test/1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("/test/2")
    public String test2(){
        return "test2";
    }
}
