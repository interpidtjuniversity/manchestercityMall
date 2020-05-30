package com.web2020.mall.service;

import com.web2020.mall.entity.Userlogin;
import java.util.List;

/**
 * 用户登陆表(Userlogin)表服务接口
 *
 * @author makejava
 * @since 2020-05-19 08:59:38
 */
public interface UserloginService {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Userlogin queryById(String username);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Userlogin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userlogin 实例对象
     * @return 实例对象
     */
    Userlogin insert(Userlogin userlogin);

    /**
     * 修改数据
     *
     * @param userlogin 实例对象
     * @return 实例对象
     */
    Userlogin update(Userlogin userlogin);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    boolean deleteById(String username);

    /**
     * 查询单条全部字段
     *
     * @param username 主键
     * @param password 密码
     * @return 实例对象
     */
    Userlogin query(String username,String password);

}