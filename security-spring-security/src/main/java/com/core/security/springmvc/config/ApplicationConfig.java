package com.core.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//相当于ApplicationContext.xml
@Configuration
//定义扫描规则 排除Controller注解的扫描
@ComponentScan(basePackages = "com.core.security.springmvc",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其他bean 比如数据库连接池 事务管理器 业务bean
}
