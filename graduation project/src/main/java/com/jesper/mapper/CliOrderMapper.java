package com.jesper.mapper;

import com.jesper.model.CliOrder;
import com.jesper.model.CliOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CliOrderMapper {
    int countByExample(CliOrderExample example);

    int deleteByExample(CliOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CliOrder record);

    int insertSelective(CliOrder record);

    List<CliOrder> selectByExample(CliOrderExample example);

    CliOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CliOrder record, @Param("example") CliOrderExample example);

    int updateByExample(@Param("record") CliOrder record, @Param("example") CliOrderExample example);

    int updateByPrimaryKeySelective(CliOrder record);

    int updateByPrimaryKey(CliOrder record);

    List<CliOrder> findByHotolid(Integer hotolId);

    // List<CliOrder> findByHotolid(Integer hotolId);


}