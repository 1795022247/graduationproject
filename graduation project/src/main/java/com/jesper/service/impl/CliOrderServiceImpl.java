package com.jesper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jesper.mapper.CliOrderMapper;
import com.jesper.mapper.ClientUserMapper;
import com.jesper.mapper.RoomMapper;
import com.jesper.model.CliOrder;
import com.jesper.model.CliOrderExample;
import com.jesper.model.ClientUser;
import com.jesper.model.Room;
import com.jesper.service.CliOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class CliOrderServiceImpl implements CliOrderService {
    @Autowired
    private CliOrderMapper CliOrderMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Override
    public int countByExample(CliOrderExample example) {
        return CliOrderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CliOrderExample example) {
        return CliOrderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return CliOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CliOrder record) {
        return CliOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(CliOrder record) {
        return CliOrderMapper.insertSelective(record);
    }

    @Override
    public List<CliOrder> selectByExample(CliOrderExample example) {
        return null;
    }

    @Override
    public CliOrder selectByPrimaryKey(Integer id) {
        return CliOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(CliOrder record, CliOrderExample example) {
        return CliOrderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(CliOrder record, CliOrderExample example) {
        return CliOrderMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(CliOrder record) {
        return CliOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CliOrder record) {
        return CliOrderMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<CliOrder> findByCliId(Integer id, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);


        CliOrderExample example = new CliOrderExample();

        CliOrderExample.Criteria criteria = example.createCriteria();

        criteria.andClientIdEqualTo(id);

        List<CliOrder> cliOrders = CliOrderMapper.selectByExample(example);

        for (int i = 0; i < cliOrders.size(); i++) {
            Room room = roomMapper.selectByPrimaryKey(cliOrders.get(i).getRoomId());

            cliOrders.get(i).setFlag5(room.getRoomName());
            cliOrders.get(i).setFlag4(room.getPrice() + "");


        }


        for (int i = 0; i < cliOrders.size(); i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String date = simpleDateFormat.format(cliOrders.get(i).getCateateDate());

            cliOrders.get(i).setFlag3(date);
        }

        PageInfo<CliOrder> cliOrderPageInfo = new PageInfo<>(cliOrders);

        return cliOrderPageInfo;
    }


    @Override
    public PageInfo<CliOrder> findByAdminHotolId(Integer hotolId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);

        CliOrderExample example = new CliOrderExample();

        CliOrderExample.Criteria criteria = example.createCriteria();

        criteria.andHotolIdEqualTo(hotolId);

        List<CliOrder> cliOrders = CliOrderMapper.selectByExample(example);

        for (int i = 0; i < cliOrders.size(); i++) {
            ClientUser clientUser = clientUserMapper.selectByPrimaryKey(cliOrders.get(i).getClientId());

            cliOrders.get(i).setFlag5(clientUser.getClientName());
            cliOrders.get(i).setFlag4(clientUser.getIcCard());

        }


        PageInfo<CliOrder> cliOrderPageInfo = new PageInfo<>(cliOrders);

        return cliOrderPageInfo;
    }


    @Override
    public List<CliOrder> findByAdmin(Integer hotolId) {


        List<CliOrder> cliOrders = CliOrderMapper.findByHotolid(hotolId);
        return cliOrders;

    }


    @Override
    public PageInfo<CliOrder> findByAdminHotolId_sign(Integer hotolId, Integer page, Integer limit, int sign) {


      //  admin.getHotolId(), page, limit, sign
        PageHelper.startPage(page, limit);

        CliOrderExample example = new CliOrderExample();

        CliOrderExample.Criteria criteria = example.createCriteria();

        //criteria.andHotolIdEqualTo(hotolId);
        criteria.andSignEqualTo(sign);

        List<CliOrder> cliOrders = CliOrderMapper.selectByExample(example);

        System.out.println(cliOrders.size()+"--------------------");





        try {
            for (int i = 0; i < cliOrders.size(); i++) {

                ClientUser clientUser = clientUserMapper.selectByPrimaryKey(cliOrders.get(i).getClientId());

                cliOrders.get(i).setFlag5(clientUser.getClientName());
                cliOrders.get(i).setFlag4(clientUser.getIcCard());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String date = simpleDateFormat.format(cliOrders.get(i).getCateateDate());
                cliOrders.get(i).setFlag3(date);

            }


            PageInfo<CliOrder> cliOrderPageInfo = new PageInfo<>(cliOrders);
            cliOrderPageInfo.setList(cliOrders);
            System.out.println(cliOrderPageInfo);

            return cliOrderPageInfo;
        } catch (Exception e) {
            return null;
        }


    }


    @Override
    public PageInfo<CliOrder> findByAdminHotolLikeRoomId(Integer hotolId, Integer page, Integer limit, int sign,CliOrder cliOrder) {

        PageHelper.startPage(page, limit);


        CliOrderExample example = new CliOrderExample();

        CliOrderExample.Criteria criteria = example.createCriteria();

        //criteria.andHotolIdEqualTo(hotolId);
        criteria.andSignEqualTo(sign);

        criteria.andRoomIdEqualTo(cliOrder.getRoomId());



        List<CliOrder> cliOrders = CliOrderMapper.selectByExample(example);

        for (int i = 0; i < cliOrders.size(); i++) {
            ClientUser clientUser = clientUserMapper.selectByPrimaryKey(cliOrders.get(i).getClientId());

            cliOrders.get(i).setFlag5(clientUser.getClientName());
            cliOrders.get(i).setFlag4(clientUser.getIcCard());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String date = simpleDateFormat.format(cliOrders.get(i).getCateateDate());
            cliOrders.get(i).setFlag3(date);

        }


        PageInfo<CliOrder> cliOrderPageInfo = new PageInfo<>(cliOrders);

        return cliOrderPageInfo;
    }
}