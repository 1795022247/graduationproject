package com.jesper.mapper;

import com.jesper.model.Hotol;
import com.jesper.model.HotolExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface HotolMapper {
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