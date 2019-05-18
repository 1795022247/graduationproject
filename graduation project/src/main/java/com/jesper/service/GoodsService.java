package com.jesper.service;

import com.github.pagehelper.PageInfo;
import com.jesper.model.Admin;
import com.jesper.model.Goods;
import com.jesper.model.GoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    PageInfo<Goods> findByAdmin(Admin admin, Integer page, Integer limit);

    PageInfo<Goods> findByGoods(Admin admin, Integer page, Integer limit, Goods goods);
}
