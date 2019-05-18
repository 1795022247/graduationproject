package com.jesper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jesper.mapper.GoodsMapper;
import com.jesper.model.*;
import com.jesper.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper GoodsMapper;

    @Override
    public int countByExample(GoodsExample example) {
        return GoodsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsExample example) {
        return GoodsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return GoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Goods record) {
        return GoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return GoodsMapper.insertSelective(record);
    }

    @Override
    public List<Goods> selectByExample(GoodsExample example) {
        return null;
    }

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return GoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Goods record, GoodsExample example) {
        return GoodsMapper .updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Goods record, GoodsExample example) {
        return GoodsMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return GoodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return GoodsMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<Goods> findByAdmin(Admin admin, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andHotolIdEqualTo(admin.getHotolId());
        List<Goods> GoodsList = GoodsMapper.selectByExample(example);
        PageInfo<Goods> info = new PageInfo<>(GoodsList);
        System.out.println(info.getList()+"---------------");

        return info;

    }

    @Override
    public PageInfo<Goods> findByGoods(Admin admin, Integer page, Integer limit, Goods goods) {
        PageHelper.startPage(page, limit);
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        criteria.andHotolIdEqualTo(admin.getHotolId());

        List<Goods> GoodsList = GoodsMapper.selectByExample(example);
        PageInfo<Goods> info = new PageInfo<>(GoodsList);
        System.out.println(info.getList()+"---------------");

        return info;
    }
}