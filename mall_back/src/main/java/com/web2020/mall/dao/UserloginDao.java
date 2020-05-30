package com.web2020.mall.dao;

import com.web2020.mall.entity.Userlogin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户登陆表(Userlogin)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-19 08:59:37
 */
public interface UserloginDao {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Userlogin queryById(String username);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Userlogin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userlogin 实例对象
     * @return 对象列表
     */
    List<Userlogin> queryAll(Userlogin userlogin);

    /**
     * 新增数据
     *
     * @param userlogin 实例对象
     * @return 影响行数
     */
    int insert(Userlogin userlogin);

    /**
     * 修改数据
     *
     * @param userlogin 实例对象
     * @return 影响行数
     */
    int update(Userlogin userlogin);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 影响行数
     */
    int deleteById(String username);


    /**
     * 查询单条数据全部字段
     *
     * @param username 主键
     * @return 实例对象
     */
    Userlogin query(String username,String password);

}