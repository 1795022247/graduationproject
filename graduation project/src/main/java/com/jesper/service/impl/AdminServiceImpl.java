package com.jesper.service.impl;

import com.jesper.mapper.AdminMapper;
import com.jesper.model.Admin;
import com.jesper.model.AdminExample;
import com.jesper.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int countByExample(AdminExample example) {
        return adminMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return null;
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return adminMapper .updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return adminMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }


    /*
   执行登陆查询
     */
    @Override
    public Admin ToLoginfindByAdmin(Admin admin) {

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminNameEqualTo(admin.getAdminName());

        criteria.andPasswordEqualTo(admin.getPassword());

        try {
            return adminMapper.selectByExample(example).get(0);
        } catch (Exception e) {
        }
        return null;
    }
}
