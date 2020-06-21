package com.core.securityspringboot.security;

import com.core.securityspringboot.dao.UserDao;
import com.core.securityspringboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDao.getUserByUserName(username);
        if (userDto == null){
            return null;
        }
        List<String> permissions = userDao.getRoleByUsername(username);
        //将permissions转为数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        //返回数据库的数据
        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
