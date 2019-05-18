package com.jesper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jesper.mapper.RoomMapper;
import com.jesper.model.Admin;
import com.jesper.model.Room;
import com.jesper.model.RoomExample;
import com.jesper.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper RoomMapper;

    @Override
    public int countByExample(RoomExample example) {
        return RoomMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoomExample example) {
        return RoomMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return RoomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Room record) {
        return RoomMapper.insert(record);
    }

    @Override
    public int insertSelective(Room record) {
        return RoomMapper.insertSelective(record);
    }

    @Override
    public List<Room> selectByExample(RoomExample example) {
        return null;
    }

    @Override
    public Room selectByPrimaryKey(Integer id) {
        return RoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Room record, RoomExample example) {
        return RoomMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Room record, RoomExample example) {
        return RoomMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {
        return RoomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Room record) {
        return RoomMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<Room> findByAdmin(Admin admin, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();
        //criteria.andHotolIdEqualTo(admin.getHotolId());
        List<Room> roomList = RoomMapper.selectByExample(example);
        PageInfo<Room> info = new PageInfo<>(roomList);
        System.out.println(info.getList()+"---------------");

        return info;


    }

    @Override
    public PageInfo<Room> findByRoom(Admin admin, Integer page, Integer limit, Room room) {
        PageHelper.startPage(page, limit);
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();



        criteria.andHotolIdEqualTo(admin.getHotolId());

        if (room.getRoomNo()!=null&&!room.getRoomNo().equals("")){
            criteria.andRoomNoLike("%"+room.getRoomNo()+"%");
        }
        if(room.getRoomType()!=null&&!room.getRoomType().equals("")){
            criteria.andRoomTypeEqualTo('%'+room.getRoomType()+"%");

        }
        if(room.getSign()!=null&&!room.getSign().equals(""))
        {
            criteria.andSignEqualTo(room.getSign());
        }


        List<Room> roomList = RoomMapper.selectByExample(example);
        PageInfo<Room> info = new PageInfo<>(roomList);
        System.out.println(info.getList()+"---------------");

        return info;


    }


    @Override
    public Map<String, Object> selectByList() {

        Map<String ,Object> map=new HashMap<>();
        for(int i=0;i<7;i++){

            RoomExample example=new RoomExample();

            RoomExample.Criteria criteria=example.createCriteria();

            //criteria.andRoomTypeEqualTo(i+"");
            criteria.andSignEqualTo(i);

            List<Room> roomList=RoomMapper.selectByExample(example);

            for (int j=0;j<roomList.size();j++){
                if (roomList.get(j).getRoomType().equals("1")){
                    roomList.get(j).setFlag4("经济舒适单人间");
                }
                if (roomList.get(j).getRoomType().equals("2")){
                    roomList.get(j).setFlag4("商务双休房");
                }
                if (roomList.get(j).getRoomType().equals("3")){
                    roomList.get(j).setFlag4("普通标准间");
                }
                if (roomList.get(j).getRoomType().equals("4")){
                    roomList.get(j).setFlag4("豪华总统套房");
                }
            }
            map.put("roomList"+i,roomList);
        }


        return map;
    }
}