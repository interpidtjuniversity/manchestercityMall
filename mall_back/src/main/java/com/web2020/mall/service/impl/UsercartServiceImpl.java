package com.web2020.mall.service.impl;

import com.web2020.mall.entity.Usercart;
import com.web2020.mall.dao.UsercartDao;
import com.web2020.mall.service.UsercartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户购物车表(Usercart)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 09:07:11
 */
@Service("usercartService")
public class UsercartServiceImpl implements UsercartService {
    @Resource
    private UsercartDao usercartDao;

    @Override
    public List<Usercart> getCart(String username) {
        return this.usercartDao.getCart(username);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    @Override
    public Usercart queryById(String username,Integer goodId) {
        return this.usercartDao.queryById(username,goodId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Usercart> queryAllByLimit(int offset, int limit) {
        return this.usercartDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param usercart 实例对象
     * @return 实例对象
     */
    @Override
    public Usercart insert(Usercart usercart) {
        this.usercartDao.insert(usercart);
        return usercart;
    }

    /**
     * 修改数据
     *
     * @param usercart 实例对象
     * @return 实例对象
     */
    @Override
    public Usercart update(Usercart usercart) {
        this.usercartDao.update(usercart);
        return this.queryById(usercart.getUsername(),usercart.getGoodid());
    }

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String username) {
        return this.usercartDao.deleteById(username) > 0;
    }
}