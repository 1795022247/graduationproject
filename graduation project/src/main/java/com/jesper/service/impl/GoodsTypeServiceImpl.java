package com.jesper.service.impl;

import com.jesper.mapper.GoodsTypeMapper;
import com.jesper.model.GoodsType;
import com.jesper.model.GoodsTypeExample;
import com.jesper.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper GoodsTypeMapper;

    @Override
    public int countByExample(GoodsTypeExample example) {
        return GoodsTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsTypeExample example) {
        return GoodsTypeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return GoodsTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsType record) {
        return GoodsTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsType record) {
        return GoodsTypeMapper.insertSelective(record);
    }

    @Override
    public List<GoodsType> selectByExample(GoodsTypeExample example) {
        return null;
    }

    @Override
    public GoodsType selectByPrimaryKey(Integer id) {
        return GoodsTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsType record, GoodsTypeExample example) {
        return GoodsTypeMapper .updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsType record, GoodsTypeExample example) {
        return GoodsTypeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsType record) {
        return GoodsTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return GoodsTypeMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<GoodsType> findAll() {
        GoodsTypeExample example=new GoodsTypeExample();
        GoodsTypeExample.Criteria criteria=example.createCriteria();

        return GoodsTypeMapper.selectByExample(example);
    }
}