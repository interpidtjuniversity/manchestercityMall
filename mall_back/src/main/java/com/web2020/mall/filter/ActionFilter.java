package com.web2020.mall.filter;


import com.web2020.mall.service.UsercartService;
import com.web2020.mall.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "actionFilter",urlPatterns = "/action/*")
@Order(value = 10)
public class ActionFilter implements Filter{

    @Autowired
    UserloginService loginService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        //校验用户权限
        Cookie[] cookies = request.getCookies();
        String value  = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("autoLogin")) {
                value = cookies[i].getValue();
                break;
            }
        }
        if(value != null){
            String username = value.split("\\.")[0];
            String password = value.split("\\.")[1];

            if (loginService.query(username,password)!=null){
                request.getSession().setAttribute("username",username);
                request.getSession().setAttribute("password",password);
            }
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化!");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器已销毁!");
    }
}
