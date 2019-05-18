package com.jesper.service;

import com.github.pagehelper.PageInfo;
import com.jesper.model.Admin;
import com.jesper.model.Room;
import com.jesper.model.RoomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoomService {

    int countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    PageInfo<Room> findByAdmin(Admin admin, Integer page, Integer limit);

    PageInfo<Room> findByRoom(Admin admin, Integer page, Integer limit, Room room);

    Map<String, Object> selectByList();
}
