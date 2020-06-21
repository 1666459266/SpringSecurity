package com.core.security.springmvc.service.serviceimpl;

import com.core.security.springmvc.model.AuthenticationRequest;
import com.core.security.springmvc.model.UserDto;
import com.core.security.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        //校验参数是否为空
        if (authenticationRequest == null || StringUtils.isEmpty(authenticationRequest.getUsername()) || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("账号或密码为空");
        }
        //模拟数据库查询
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if (userDto == null){
            throw new RuntimeException("该用户不存在");
        }
        if (!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("账号或密码错误");
        }
        return userDto;
    }

    //模拟用户查询
    public UserDto getUserDto(String username) {
        return userDtoMap.get(username);
    }

    //用户信息
    private Map<String,UserDto> userDtoMap = new HashMap<>();

    {
        Set<String> authorities1 = new HashSet<>();
        //权限标识 与请求路径对应
        authorities1.add("p1");
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");
        userDtoMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","***",authorities1));
        userDtoMap.put("lisi",new UserDto("1011","lisi","123","lisi","***",authorities2));
    }
}
