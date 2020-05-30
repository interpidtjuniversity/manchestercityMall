package com.web2020.mall.controller;

import com.web2020.mall.entity.Userlogin;
import com.web2020.mall.service.UserloginService;
import com.web2020.mall.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆表(Userlogin)表控制层
 *
 * @author makejava
 * @since 2020-05-19 08:59:38
 */
@RestController
@RequestMapping("/user")
public class UserloginController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private UserloginService userloginService;

    /**
     * 通过主键查询单条数据
     *
     * @param username 主键
     * @return 单条数据
     */
    @ResponseBody
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) {
        if(this.userloginService.query(username,password)!=null){
            //设置cookie
            Cookie cookie = new Cookie("autoLogin",username+"."+password);
            cookie.setMaxAge(36000);
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResultUtil.SimpleResult("success");
        }
        else
            return ResultUtil.SimpleResult("failure");
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response,@RequestParam("username") String username,@RequestParam("password") String password) {
        if(this.userloginService.queryById(username)!=null){
            return ResultUtil.SimpleResult("failure");
        }
        this.userloginService.insert(new Userlogin(username,password));
        return ResultUtil.SimpleResult("success");
    }
}