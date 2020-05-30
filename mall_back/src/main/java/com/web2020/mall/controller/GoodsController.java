package com.web2020.mall.controller;

import com.web2020.mall.entity.Goods;
import com.web2020.mall.service.GoodsService;
import com.web2020.mall.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 货物表(Goods)表控制层
 *
 * @author makejava
 * @since 2020-05-19 09:00:30
 */
@RestController
@RequestMapping("/action/goods")
public class GoodsController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Goods selectOne(Integer id) {
        return this.goodsService.queryById(id);
    }


    @ResponseBody
    @GetMapping("/indexVerify")
    public String indexVerify(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String username = (String)request.getSession().getAttribute("username");
        if(username==null)
            return ResultUtil.SimpleResult("unauthorized");

        return ResultUtil.SimpleResult(username);
    }

}