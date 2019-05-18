package com.jesper.service;

import com.github.pagehelper.PageInfo;
import com.jesper.model.Admin;
import com.jesper.model.CliOrder;
import com.jesper.model.ClientUser;
import com.jesper.model.ClientUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientUserService {
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

    ClientUser ToLoginfindByUser(ClientUser clientUser);


    PageInfo<ClientUser> findBy(List<CliOrder> cliOrderList,Integer id);

    PageInfo<ClientUser> findByUserList(ClientUser clientUser, Admin admin, Integer page, Integer limit);
}
