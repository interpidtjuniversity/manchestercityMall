package com.web2020.mall.entity;

import java.io.Serializable;

/**
 * 用户购物车表(Usercart)实体类
 *
 * @author makejava
 * @since 2020-05-19 09:00:07
 */
public class Usercart implements Serializable {
    private static final long serialVersionUID = -55518858731336425L;

    private String username;

    private Integer goodid;

    private Integer goodnum;

    public Usercart(String username, Integer goodid, Integer goodnum) {
        this.username = username;
        this.goodid = goodid;
        this.goodnum = goodnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Integer goodnum) {
        this.goodnum = goodnum;
    }

}