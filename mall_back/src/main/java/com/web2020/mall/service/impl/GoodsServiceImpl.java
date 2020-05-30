package com.web2020.mall.service.impl;

import com.web2020.mall.entity.Goods;
import com.web2020.mall.dao.GoodsDao;
import com.web2020.mall.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 货物表(Goods)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 09:07:00
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodid 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer goodid) {
        return this.goodsDao.queryById(goodid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllByLimit(int offset, int limit) {
        return this.goodsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsDao.update(goods);
        return this.queryById(goods.getGoodid());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodid) {
        return this.goodsDao.deleteById(goodid) > 0;
    }
}