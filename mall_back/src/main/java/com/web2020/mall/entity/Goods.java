package com.web2020.mall.entity;

import java.io.Serializable;

/**
 * 货物表(Goods)实体类
 *
 * @author makejava
 * @since 2020-05-19 09:00:30
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = 844729477423443447L;
    
    private Integer goodid;
    
    private String goodname;
    
    private Integer goodprice;
    
    private String gooddeliveryplace;


    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Integer getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Integer goodprice) {
        this.goodprice = goodprice;
    }

    public String getGooddeliveryplace() {
        return gooddeliveryplace;
    }

    public void setGooddeliveryplace(String gooddeliveryplace) {
        this.gooddeliveryplace = gooddeliveryplace;
    }

}