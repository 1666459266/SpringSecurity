package com.core.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = "text/plain;charset=utf-8")
    public String loginSuccess(){
        return getUsername()+"登录成功";
    }

    @RequestMapping("/test/1")
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限才可以访问
    //@PreAuthorize("hasAnyAuthority('p1','p2')")//拥有p1或p2权限才可以访问
    public String test1(){
        return getUsername()+"test1";
    }

    @RequestMapping("/test/2")
    @PreAuthorize("hasAuthority('p2')")//拥有p2权限才可以访问
    public String test2(){
        return getUsername()+"test2";
    }

    //获取当前用户信息
    private String getUsername(){
        String username = null;
        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //得到用户身份
        Object principal = authentication.getPrincipal();
        if (principal == null){
            username = "匿名";
        }
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
