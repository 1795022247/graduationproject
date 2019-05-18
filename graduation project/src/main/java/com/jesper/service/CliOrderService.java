package com.jesper.service;

import com.github.pagehelper.PageInfo;
import com.jesper.model.CliOrder;
import com.jesper.model.CliOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CliOrderService {

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

    PageInfo<CliOrder> findByCliId(Integer id, Integer page, Integer limit);

    PageInfo<CliOrder> findByAdminHotolId(Integer hotolId, Integer page, Integer limit);

    List<CliOrder> findByAdmin(Integer hotolId);

    PageInfo<CliOrder> findByAdminHotolId_sign(Integer hotolId, Integer page, Integer limit, int sign);

    PageInfo<CliOrder> findByAdminHotolLikeRoomId(Integer hotolId, Integer page, Integer limit, int sign,CliOrder cliOrder);
}


