package com.core.securityspringboot.dao;

import com.core.securityspringboot.model.PermissionDto;
import com.core.securityspringboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据用户名查询用户信息
    public UserDto getUserByUserName(String username){
        String sql = "select * from user where username = ?";
        List<UserDto> query = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDto.class));
        if (query == null || query.size() <= 0){
            return null;
        }
        return query.get(0);
    }

    //根据用户名查询用户角色
    public List<String> getRoleByUsername(String username){
        String sql = "select * from permission p " +
                "left join role_permission rp on p.id = rp.permission_id " +
                "left join role r on r.id = rp.role_id " +
                "left join user_role ur on ur.role_id = r.id " +
                "left join user u on ur.user_id = u.id " +
                "where username = ?";
        List<PermissionDto> query = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(PermissionDto.class));
        List<String> permissions = new ArrayList<>();
        //遍历query
        query.forEach(c -> permissions.add(c.getCode()));
        return permissions;
    }
}
