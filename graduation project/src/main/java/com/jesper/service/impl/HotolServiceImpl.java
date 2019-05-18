package com.jesper.service.impl;

import com.jesper.mapper.HotolMapper;
import com.jesper.model.Hotol;
import com.jesper.model.HotolExample;
import com.jesper.service.HotolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotolServiceImpl implements HotolService {
    @Autowired
    private HotolMapper HotolMapper;

    @Override
    public int countByExample(HotolExample example) {
        return HotolMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(HotolExample example) {
        return HotolMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return HotolMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Hotol record) {
        return HotolMapper.insert(record);
    }

    @Override
    public int insertSelective(Hotol record) {
        return HotolMapper.insertSelective(record);
    }

    @Override
    public List<Hotol> selectByExample(HotolExample example) {
        return null;
    }

    @Override
    public Hotol selectByPrimaryKey(Integer id) {
        return HotolMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Hotol record, HotolExample example) {
        return HotolMapper .updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Hotol record, HotolExample example) {
        return HotolMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Hotol record) {
        return HotolMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Hotol record) {
        return HotolMapper.updateByPrimaryKey(record);
    }
}