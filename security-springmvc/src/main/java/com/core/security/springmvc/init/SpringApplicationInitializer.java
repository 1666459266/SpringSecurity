package com.core.security.springmvc.init;

import com.core.security.springmvc.config.ApplicationConfig;
import com.core.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//定义Spring容器初始化类 此类实现WebApplicationInitializer接口 Spring容器启动时加载WebApplicationInitializer接口的所有实现类
//相当于web.xml 使用Servlet3.0不需要再定义web.xml
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Spring容器 相当于加载ApplicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    //ServletContext 相当于加载SpringMvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //url-Mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
