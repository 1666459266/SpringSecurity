package com.core.securityspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//不需要配置 @EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true) //开启@Secured
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启@PreAuthorize
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //用户信息服务
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
//        manager.createUser(User.withUsername("lisi").password("123").authorities("p2").build());
//        return manager;
//    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//屏蔽CSRF控制 SpringSecurity不再限制CSRF
                .authorizeRequests()
//                .antMatchers("/test/1").hasAuthority("p1") //必须含有p1权限
//                .antMatchers("/test/2").hasAuthority("p2") //必须含有p2权限
                .antMatchers("/test/**").authenticated() //所有/test/**的请求必须认证通过
                .anyRequest().permitAll() //除了/test/**其他请求可以访问
                .and()
                .formLogin() //允许表单登录
//                .loginPage("/login_view")//自定义登录页面
//                .loginProcessingUrl("/login")//自定义登录地址
                .successForwardUrl("/login-success") //自定义登录成功的URL地址
//                .and()
//                .logout()
//                .logoutUrl("/logout")//自定义的退出URL
//                .logoutSuccessUrl("/login_view/logout")//自定义跳转地址
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);//会话控制管理
    }
}
