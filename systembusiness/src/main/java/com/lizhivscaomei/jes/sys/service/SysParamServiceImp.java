package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysParam;
import com.lizhivscaomei.jes.sys.dao.SysParamMapper;
import com.lizhivscaomei.jes.sys.entity.SysParamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysParamServiceImp implements SysParamService {
    @Autowired
    SysParamMapper sysParamMapper;

    public void add(SysParam entity) throws AppException {
        if(entity!=null){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            //默认数据
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            entity.setDelFlag("0");
            this.sysParamMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysParam entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysParamMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysParamMapper.deleteByPrimaryKey(id);
    }

    public SysParam getById(String id) {
        return this.sysParamMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysParam> queryPage(SysParam entity, Page page) {
        SysParamExample example=new SysParamExample();
        SysParamExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(entity.getDomainId());
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysParam> list= this.sysParamMapper.selectByExample(example);
        return new PageInfo<SysParam>(list);
    }
}
