package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysDomain;
import com.lizhivscaomei.jes.sys.dao.SysDomainMapper;
import com.lizhivscaomei.jes.sys.entity.SysDomainExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysDomainServiceImp implements SysDomainService {
    @Autowired
    SysDomainMapper sysDomainMapper;

    public void add(SysDomain entity) throws AppException {
        if(entity!=null){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            //默认数据
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            this.sysDomainMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysDomain entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysDomainMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysDomainMapper.deleteByPrimaryKey(id);
    }

    public SysDomain getById(String id) {
        return this.sysDomainMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysDomain> queryPage(SysDomain entity, Page page) {
        SysDomainExample example=new SysDomainExample();
        example.setOrderByClause("code asc");
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysDomain> list= this.sysDomainMapper.selectByExample(example);
        return new PageInfo<SysDomain>(list);
    }

    @Override
    public List<SysDomain> queryAll() {
        SysDomainExample example=new SysDomainExample();
        example.setOrderByClause("code asc");
        List<SysDomain> list= this.sysDomainMapper.selectByExample(example);
        return list;
    }
}
