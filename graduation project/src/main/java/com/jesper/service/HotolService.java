package com.jesper.service;

import com.jesper.model.Hotol;
import com.jesper.model.HotolExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotolService {

    int countByExample(HotolExample example);

    int deleteByExample(HotolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hotol record);

    int insertSelective(Hotol record);

    List<Hotol> selectByExample(HotolExample example);

    Hotol selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hotol record, @Param("example") HotolExample example);

    int updateByExample(@Param("record") Hotol record, @Param("example") HotolExample example);

    int updateByPrimaryKeySelective(Hotol record);

    int updateByPrimaryKey(Hotol record);
}
