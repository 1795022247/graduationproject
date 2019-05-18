package com.jesper.service.impl;

import com.github.pagehelper.PageInfo;
import com.jesper.mapper.ClientUserMapper;
import com.jesper.model.Admin;
import com.jesper.model.CliOrder;
import com.jesper.model.ClientUser;
import com.jesper.model.ClientUserExample;
import com.jesper.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientUserServiceImpl implements ClientUserService {
    @Autowired
    private ClientUserMapper ClientUserMapper;

    @Override
    public int countByExample(ClientUserExample example) {
        return ClientUserMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ClientUserExample example) {
        return ClientUserMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ClientUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ClientUser record) {
        return ClientUserMapper.insert(record);
    }

    @Override
    public int insertSelective(ClientUser record) {
        return ClientUserMapper.insertSelective(record);
    }

    @Override
    public List<ClientUser> selectByExample(ClientUserExample example) {
        return null;
    }

    @Override
    public ClientUser selectByPrimaryKey(Integer id) {
        return ClientUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ClientUser record, ClientUserExample example) {
        return ClientUserMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ClientUser record, ClientUserExample example) {
        return ClientUserMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ClientUser record) {
        return ClientUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ClientUser record) {
        return ClientUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public ClientUser ToLoginfindByUser(ClientUser clientUser) {
        ClientUserExample example = new ClientUserExample();
        ClientUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(clientUser.getPhone());

        criteria.andPasswordEqualTo(clientUser.getPassword());
        try {
            return ClientUserMapper.selectByExample(example).get(0);
        } catch (Exception e) {
        }
        return null;
    }


    @Override
    public PageInfo<ClientUser> findBy(List<CliOrder> cliOrderList, Integer id) {

//        List<ClientUser> clientUserList = new ArrayList<>();
//        for (int i = 0; i < cliOrderList.size(); i++) {
//            ClientUser clientUser = ClientUserMapper.selectByPrimaryKey(cliOrderList.get(i).getClientId());
//            clientUserList.add(clientUser);
//        }

       ClientUserExample example = new ClientUserExample();
        ClientUserExample.Criteria criteria = example.createCriteria();
       // criteria.andFlag1EqualTo(id + "");
        List<ClientUser> clientUserList1 = ClientUserMapper.selectByExample(example);

       // clientUserList.addAll(clientUserList1);
        PageInfo<ClientUser> clientUserPageInfo = new PageInfo<>(clientUserList1);

        return clientUserPageInfo;


    }


    @Override
    public PageInfo<ClientUser> findByUserList(ClientUser clientUser, Admin admin, Integer page, Integer limit) {

        ClientUserExample example = new ClientUserExample();
        ClientUserExample.Criteria criteria = example.createCriteria();
       // criteria.andFlag1EqualTo(admin.getHotolId()+"");
        if (clientUser.getClientName()!=null&&!clientUser.getClientName().equals(""))
        {
            criteria.andClientNameLike('%'+clientUser.getClientName()+'%');
        }
        if (clientUser.getPhone()!=null&&!clientUser.getPhone().equals(""))
        {
            criteria.andPhoneLike("%"+clientUser.getClientName()+"%");
        }

        List<ClientUser> clientUserList1 = ClientUserMapper.selectByExample(example);

        // clientUserList.addAll(clientUserList1);
        PageInfo<ClientUser> clientUserPageInfo = new PageInfo<>(clientUserList1);

        return clientUserPageInfo;


    }
}