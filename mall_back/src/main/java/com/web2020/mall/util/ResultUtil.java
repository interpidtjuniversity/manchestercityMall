package com.web2020.mall.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web2020.mall.entity.Goods;
import com.web2020.mall.entity.Order;
import com.web2020.mall.entity.Usercart;

import java.util.List;

public class ResultUtil {
    public static String SimpleResult(String result){
        JSONObject data = new JSONObject();
        data.put("opRes",result);
        return data.toJSONString();
    }

    public static String MultiResult(String result, List<Usercart>usercartList, List<Goods>goodsList){
        JSONObject data = new JSONObject();
        data.put("opRes",result);
        data.put("dataResSize",usercartList.size());

        JSONArray dataRes = new JSONArray();
        for(int i=0;i<usercartList.size();i++){
            JSONObject o = new JSONObject();
            Usercart usercart = usercartList.get(i);
            Goods goods = goodsList.get(i);

            o.put("goodId",usercart.getGoodid());
            o.put("goodMessage",goods.getGoodname());
            o.put("goodDeliveryPlace",goods.getGooddeliveryplace());
            o.put("goodPrice",goods.getGoodprice());
            o.put("goodNum",usercart.getGoodnum());
            dataRes.add(o);
        }
        data.put("dataRes", JSON.toJSONString(dataRes));
        return data.toJSONString();
    }

    public static String MultiResult(String result, List<Order>orderList, String[] goodMessages){
        JSONObject data = new JSONObject();
        data.put("opRes",result);
        data.put("dataResSize",orderList.size());

        JSONArray dataRes = new JSONArray();
        for(int i=0;i<orderList.size();i++){
            JSONObject o = new JSONObject();
            Order order = orderList.get(i);

            o.put("orderId",order.getOrderid());
            o.put("goodId",order.getGoodid());
            o.put("goodNum",order.getGoodnum());
            o.put("goodDeliveryPlace",order.getGooddeliveryplace());
            o.put("totalPrice",order.getTotalprice());
            o.put("goodMessage",goodMessages[i]);
            dataRes.add(o);
        }
        data.put("dataRes", JSON.toJSONString(dataRes));
        return data.toJSONString();
    }
}
