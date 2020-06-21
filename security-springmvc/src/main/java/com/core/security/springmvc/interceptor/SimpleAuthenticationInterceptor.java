package com.core.security.springmvc.interceptor;

import com.core.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    //在进入Handler方法执行之前执行此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null){
            writeContent(response,"请登录");
        }
        UserDto userDto = (UserDto) object;
        //根据请求的url比对
        String requestURI = request.getRequestURI();
        if (userDto.getAuthorities().contains("p1") && request.getRequestURI().contains("/test/session1")){
            return true;
        }
        if (userDto.getAuthorities().contains("p2")&&request.getRequestURI().contains("/test/session2")){
            return true;
        }
        writeContent(response,"没有权限拒绝访问");
        return false;
    }

    //响应信息给客户端
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
    }

    //在进入Handler方法之后 返回ModelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在Handler方法执行完之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
