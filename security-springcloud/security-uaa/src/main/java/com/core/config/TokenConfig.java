package com.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenConfig {
    //令牌存储策略
    //令牌存储的方案（一般单独建立一个类进行配置）
    //InMemoryTokenStore默认采用的方式存在内存中
    //JdbcTokenStore基于jdbc的实现 令牌将保存到数据库
    //JwtTokenStore全称是JSON Web Token 可以将相关令牌数据进行编码 不需要进行存储
    @Bean
    public TokenStore tokenStore(){
        //采用内存方式 生成普通令牌
        return new InMemoryTokenStore();
    }
}
