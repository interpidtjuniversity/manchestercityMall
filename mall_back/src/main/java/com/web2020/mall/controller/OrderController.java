package com.web2020.mall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web2020.mall.entity.Goods;
import com.web2020.mall.entity.Order;
import com.web2020.mall.service.GoodsService;
import com.web2020.mall.service.OrderService;
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
 * 订单表(Order)表控制层
 *
 * @author makejava
 * @since 2020-05-19 09:00:16
 */
@RestController
@RequestMapping("/action/order")
public class OrderController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;


    /**
     * 保存订单
     */
    @PostMapping("/saveOrders")
    @ResponseBody
    public String saveOrders(ServletRequest servletRequest, ServletResponse servletResponse,@RequestParam("orders") String data) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        JSONArray orders = JSON.parseArray(data);

        for(int i=0;i<orders.size();i++){
            Order o = new Order();
            o.setGoodid((int)orders.getJSONObject(i).get("goodId"));
            o.setGoodnum((int)orders.getJSONObject(i).get("goodNum"));
            o.setGooddeliveryplace((String)orders.getJSONObject(i).get("goodDeliveryPlace"));
            o.setTotalprice((int)orders.getJSONObject(i).get("totalPrice"));
            o.setUsername(username);
            o.setOrderid(null);
            orderService.insert(o);
        }

        return ResultUtil.SimpleResult("success");
    }


    /**
     * 查看订单
     */
    @GetMapping("/getOrders")
    @ResponseBody
    public String getOrders(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        List<Order>orders = this.orderService.getOrders(username);
        String[] goodMessages = new String[orders.size()];
        for(int i=0;i<orders.size();i++){
            Goods g = this.goodsService.queryById(orders.get(i).getGoodid());
            goodMessages[i] = g.getGoodname();
        }

        return ResultUtil.MultiResult("success",orders,goodMessages);
    }

    @ResponseBody
    @PostMapping("/orderVerify")
    public String orderVerify(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        return ResultUtil.SimpleResult("success");
    }
}