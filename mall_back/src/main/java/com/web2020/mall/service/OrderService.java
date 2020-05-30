package com.web2020.mall.service;

import com.web2020.mall.entity.Order;

import java.util.List;

/**
 * 订单表(Order)表服务接口
 *
 * @author makejava
 * @since 2020-05-19 09:00:16
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    Order queryById(Integer orderid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderid);

    /**
    * @param username 用户名
    * */
    List<Order> getOrders(String username);

}