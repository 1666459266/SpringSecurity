package com.core.security.springmvc.service;

import com.core.security.springmvc.model.AuthenticationRequest;
import com.core.security.springmvc.model.UserDto;

public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求 账号和密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
