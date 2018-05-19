package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.SysDictMapper;
import com.lizhivscaomei.jes.sys.entity.SysDict;
import com.lizhivscaomei.jes.sys.entity.SysDictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SysDictServiceImp implements SysDictService {
    @Autowired
    SysDictMapper sysDictMapper;

    public void add(SysDict entity) throws AppException {
        if(entity!=null){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            //默认数据
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            this.sysDictMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysDict entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysDictMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysDictMapper.deleteByPrimaryKey(id);
    }

    public SysDict getById(String id) {
        return this.sysDictMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysDict> queryPage(SysDict entity, Page page) {
        SysDictExample example=new SysDictExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysDict> list= this.sysDictMapper.selectByExample(example);
        return new PageInfo<SysDict>(list);
    }

    @Override
    public List<SysDict> getChilds(String domainId, String pid) {
        SysDictExample example=new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        criteria.andParentIdEqualTo(pid);
        return this.sysDictMapper.selectByExample(example);
    }

    @Override
    public List<SysDict> getAll(String domainId) {
        SysDict root=new SysDict();
        root.setId("0");
        root.setCode("ROOT");
        root.setName("根");
        SysDictExample example=new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        List<SysDict> list = this.sysDictMapper.selectByExample(example);
        list.add(root);
        return list;
    }
}
