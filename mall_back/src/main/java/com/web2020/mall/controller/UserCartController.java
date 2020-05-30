package com.web2020.mall.controller;

import com.web2020.mall.annotation.Limit;
import com.web2020.mall.entity.Goods;
import com.web2020.mall.entity.Usercart;
import com.web2020.mall.enumerate.LimitType;
import com.web2020.mall.service.GoodsService;
import com.web2020.mall.service.UsercartService;
import com.web2020.mall.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户购物车表(Usercart)表控制层
 *
 * @author makejava
 * @since 2020-05-19 09:00:07
 */
@RestController
@RequestMapping("/action/userCart")
public class UserCartController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private UsercartService usercartService;

    @Autowired
    private GoodsService goodsService;

    /*
    * 添加购物车
    * */
    @ResponseBody
    @PostMapping("/addCart")
    @Limit(period = 10, count = 2, limitType = LimitType.IP)
    public String addCart(ServletRequest servletRequest, ServletResponse servletResponse,@RequestParam("goodId") Integer goodId){
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        Usercart usercart = this.usercartService.queryById(username,goodId);
        if(usercart == null){
            this.usercartService.insert(new Usercart(username,goodId,1));
        }
        else {
            usercart.setGoodnum(usercart.getGoodnum() + 1);
            this.usercartService.update(usercart);
        }
        return ResultUtil.SimpleResult("success");
    }


    /*
     * 浏览购物车
     * */
    @ResponseBody
    @PostMapping("/getCart")
    public String getCart(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        //再次检验一遍
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        //查询改用户的购物车
        List<Usercart>userCart =  usercartService.getCart(username);
        List<Goods>goodsList = new ArrayList<>(userCart.size());
        for(Usercart usercart : userCart){
            Goods goods = goodsService.queryById(usercart.getGoodid());
            goodsList.add(goods);
        }

        return ResultUtil.MultiResult("success",userCart,goodsList);
    }

    @ResponseBody
    @PostMapping("/cartVerify")
    public String cartVerify(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        return ResultUtil.SimpleResult("success");
    }


    @ResponseBody
    @PostMapping("/clearCart")
    public String clearCart(ServletRequest servletRequest, ServletResponse servletResponse){
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        usercartService.deleteById(username);
        return ResultUtil.SimpleResult("success");
    }

}