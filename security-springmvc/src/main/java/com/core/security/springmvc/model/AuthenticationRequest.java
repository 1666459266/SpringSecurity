package com.core.security.springmvc.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    //认证请求参数 账号 密码
    private String username;

    private String password;
}
