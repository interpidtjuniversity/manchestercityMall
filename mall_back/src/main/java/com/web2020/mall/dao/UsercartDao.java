package com.web2020.mall.dao;

import com.web2020.mall.entity.Usercart;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户购物车表(Usercart)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-19 09:00:07
 */
public interface UsercartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param username 用户名
     * @param goodId 商品id
     * @return 实例对象
     */
    Usercart queryById(String username,Integer goodId);

    /**
     * 通过用户名查询多条数据
     *
     * @param username 条件
     * @return 实例对象
     */
    List<Usercart> getCart(String username);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Usercart> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param usercart 实例对象
     * @return 对象列表
     */
    List<Usercart> queryAll(Usercart usercart);

    /**
     * 新增数据
     *
     * @param usercart 实例对象
     * @return 影响行数
     */
    int insert(Usercart usercart);

    /**
     * 修改数据
     *
     * @param usercart 实例对象
     * @return 影响行数
     */
    int update(Usercart usercart);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 影响行数
     */
    int deleteById(String username);

}