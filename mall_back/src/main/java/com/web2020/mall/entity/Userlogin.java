package com.web2020.mall.entity;

import java.io.Serializable;

/**
 * 用户登陆表(Userlogin)实体类
 *
 * @author makejava
 * @since 2020-05-19 08:59:34
 */
public class Userlogin implements Serializable {
    private static final long serialVersionUID = -43156648656538093L;
    
    private String username;
    
    private String password;

    public Userlogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}