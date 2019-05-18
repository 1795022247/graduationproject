package com.jesper.mapper;

import com.jesper.model.ClientUser;
import com.jesper.model.ClientUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ClientUserMapper {

    int countByExample(ClientUserExample example);

    int deleteByExample(ClientUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientUser record);

    int insertSelective(ClientUser record);

    List<ClientUser> selectByExample(ClientUserExample example);

    ClientUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientUser record, @Param("example") ClientUserExample example);

    int updateByExample(@Param("record") ClientUser record, @Param("example") ClientUserExample example);

    int updateByPrimaryKeySelective(ClientUser record);

    int updateByPrimaryKey(ClientUser record);



}