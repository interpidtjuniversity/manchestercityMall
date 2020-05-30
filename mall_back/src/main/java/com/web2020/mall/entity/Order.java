package com.web2020.mall.entity;

import java.io.Serializable;

/**
 * 订单表(Order)实体类
 *
 * @author makejava
 * @since 2020-05-19 09:00:16
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -64829795328105855L;
    
    private String username;
    
    private Integer goodid;
    
    private Integer goodnum;
    
    private String gooddeliveryplace;
    
    private Integer totalprice;
    
    private Integer orderid;


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

    public String getGooddeliveryplace() {
        return gooddeliveryplace;
    }

    public void setGooddeliveryplace(String gooddeliveryplace) {
        this.gooddeliveryplace = gooddeliveryplace;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

}