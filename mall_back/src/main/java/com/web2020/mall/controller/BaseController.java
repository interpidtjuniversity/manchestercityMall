package com.web2020.mall.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cuiYao on 2020/5/19.
 */
@RestController
@CrossOrigin(origins = "http://localhost:63343")
public class BaseController {

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
    }
    protected HttpServletResponse getResponse() {
        return new ServletWebRequest(((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest()).getResponse();
    }
}
