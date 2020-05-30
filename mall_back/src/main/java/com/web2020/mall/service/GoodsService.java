package com.web2020.mall.service;

import com.web2020.mall.entity.Goods;

import java.util.List;

/**
 * 货物表(Goods)表服务接口
 *
 * @author makejava
 * @since 2020-05-19 09:00:30
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodid 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param goodid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodid);

}