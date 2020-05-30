package com.web2020.mall.service.impl;

import com.web2020.mall.entity.Order;
import com.web2020.mall.dao.OrderDao;
import com.web2020.mall.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(Order)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 09:07:06
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer orderid) {
        return this.orderDao.queryById(orderid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getOrderid());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderid) {
        return this.orderDao.deleteById(orderid) > 0;
    }


    @Override
    public List<Order> getOrders(String username) {
        return this.orderDao.getOrders(username);
    }
}