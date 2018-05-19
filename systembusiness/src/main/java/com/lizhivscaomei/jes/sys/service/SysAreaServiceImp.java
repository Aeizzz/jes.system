package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysArea;
import com.lizhivscaomei.jes.sys.dao.SysAreaMapper;
import com.lizhivscaomei.jes.sys.entity.SysAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysAreaServiceImp implements SysAreaService {
    @Autowired
    SysAreaMapper sysAreaMapper;

    public void add(SysArea entity) throws AppException {
        if(entity!=null){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            //默认数据
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            this.sysAreaMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysArea entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysAreaMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysAreaMapper.deleteByPrimaryKey(id);
    }

    public SysArea getById(String id) {
        return this.sysAreaMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysArea> queryPage(SysArea entity, Page page) {
        SysAreaExample example=new SysAreaExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysArea> list= this.sysAreaMapper.selectByExample(example);
        return new PageInfo<SysArea>(list);
    }

    @Override
    public List<SysArea> getAll() {
        List<SysArea> list = this.sysAreaMapper.selectByExample(new SysAreaExample());
        SysArea root=new SysArea();
        root.setId("0");
        root.setName("中华人民共和国");
        root.setCode("86");
        list.add(root);
        return list;
    }
}
