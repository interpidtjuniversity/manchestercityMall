package com.web2020.mall.service.impl;

import com.web2020.mall.entity.Userlogin;
import com.web2020.mall.dao.UserloginDao;
import com.web2020.mall.service.UserloginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登陆表(Userlogin)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 09:07:15
 */
@Service("userloginService")
public class UserloginServiceImpl implements UserloginService {
    @Resource
    private UserloginDao userloginDao;

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    @Override
    public Userlogin queryById(String username) {
        return this.userloginDao.queryById(username);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Userlogin> queryAllByLimit(int offset, int limit) {
        return this.userloginDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userlogin 实例对象
     * @return 实例对象
     */
    @Override
    public Userlogin insert(Userlogin userlogin) {
        this.userloginDao.insert(userlogin);
        return userlogin;
    }

    /**
     * 修改数据
     *
     * @param userlogin 实例对象
     * @return 实例对象
     */
    @Override
    public Userlogin update(Userlogin userlogin) {
        this.userloginDao.update(userlogin);
        return this.queryById(userlogin.getUsername());
    }

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String username) {
        return this.userloginDao.deleteById(username) > 0;
    }


    @Override
    public Userlogin query(String username, String password) {
        return this.userloginDao.query(username,password);
    }
}