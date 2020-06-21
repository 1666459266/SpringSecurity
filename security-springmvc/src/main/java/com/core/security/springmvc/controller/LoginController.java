package com.core.security.springmvc.controller;

import com.core.security.springmvc.model.AuthenticationRequest;
import com.core.security.springmvc.model.UserDto;
import com.core.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "login",produces = "text/plain;charset=utf-8")//指定文本类型
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        //将用户信息存入session
        session.setAttribute(userDto.SESSION_USER_KEY,userDto);
        return userDto.getUsername()+"登录成功";
    }

    @RequestMapping(value = "logout",produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    @RequestMapping(value = "/test/session1",produces = "text/plain;charset=utf-8")
    public String testSession1(HttpSession session){
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        String fullname = null;
        if (object == null){
            fullname = "匿名";
        } else {
            UserDto userDto = (UserDto) object;
            fullname = userDto.getUsername();
        }
        return fullname;
    }

    @RequestMapping(value = "/test/session2",produces = "text/plain;charset=utf-8")
    public String testSession2(HttpSession session){
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        String fullname = null;
        if (object == null){
            fullname = "匿名";
        } else {
            UserDto userDto = (UserDto) object;
            fullname = userDto.getUsername();
        }
        return fullname;
    }
}
