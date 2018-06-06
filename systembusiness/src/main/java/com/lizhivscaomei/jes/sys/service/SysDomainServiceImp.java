package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.VSysUserRoleDomainMapper;
import com.lizhivscaomei.jes.sys.entity.SysDomain;
import com.lizhivscaomei.jes.sys.dao.SysDomainMapper;
import com.lizhivscaomei.jes.sys.entity.SysDomainExample;
import com.lizhivscaomei.jes.sys.entity.VSysUserRoleDomain;
import com.lizhivscaomei.jes.sys.entity.VSysUserRoleDomainExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysDomainServiceImp implements SysDomainService {
    @Autowired
    SysDomainMapper sysDomainMapper;
    @Autowired
    VSysUserRoleDomainMapper vSysUserRoleDomainMapper;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void update(SysDomain entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysDomainMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional
    public void delete(String id) throws AppException {
        this.sysDomainMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SysDomain getById(String id) {
        return this.sysDomainMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysDomain> queryPage(SysDomain entity, Page page) {
        SysDomainExample example=new SysDomainExample();
        example.setOrderByClause("code asc");
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysDomain> list= this.sysDomainMapper.selectByExample(example);
        return new PageInfo<SysDomain>(list);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysDomain> queryAll() {
        SysDomainExample example=new SysDomainExample();
        example.setOrderByClause("code asc");
        List<SysDomain> list= this.sysDomainMapper.selectByExample(example);
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VSysUserRoleDomain> getByUser(String userId) {
        VSysUserRoleDomainExample example=new VSysUserRoleDomainExample();
        example.setDistinct(true);
        VSysUserRoleDomainExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return this.vSysUserRoleDomainMapper.selectByExample(example);
    }
}
