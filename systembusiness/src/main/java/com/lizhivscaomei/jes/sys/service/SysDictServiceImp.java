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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SysDictServiceImp implements SysDictService {
    @Autowired
    SysDictMapper sysDictMapper;

    @Transactional
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
    @Transactional
    public void update(SysDict entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysDictMapper.updateByPrimaryKeySelective(entity);
    }
    @Transactional
    public void delete(String id) throws AppException {
        this.sysDictMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SysDict getById(String id) {
        return this.sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysDict> queryPage(SysDict entity, Page page) {
        SysDictExample example=new SysDictExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysDict> list= this.sysDictMapper.selectByExample(example);
        return new PageInfo<SysDict>(list);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysDict> getChilds(String domainId, String pid) {
        SysDictExample example=new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        criteria.andParentIdEqualTo(pid);
        return this.sysDictMapper.selectByExample(example);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysDict> getChildsByCode(String domainId, String pcode) {
        //获取分类节点的ID
        SysDict category = this.getCategoryByCode(domainId, pcode);
        if(category!=null){
            //根据PID查询
            return  this.getChilds(domainId,category.getId());
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public SysDict getCategoryByCode(String domainId, String code) {
        SysDictExample example=new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        criteria.andCodeEqualTo(code);
        List<SysDict> list = this.sysDictMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public SysDict getChildByCode(String domainId, String pcode, String code) {
        SysDict category = this.getCategoryByCode(domainId,pcode);
        if(category!=null){
            SysDictExample example=new SysDictExample();
            SysDictExample.Criteria criteria = example.createCriteria();
            criteria.andDomainIdEqualTo(domainId);
            criteria.andParentIdEqualTo(category.getId());
            criteria.andCodeEqualTo(code);
            List<SysDict> childs = this.sysDictMapper.selectByExample(example);
            if(childs!=null&&childs.size()>0){
                return childs.get(0);
            }
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysDict> getAll(String domainId) {
        SysDictExample example=new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        List<SysDict> list = this.sysDictMapper.selectByExample(example);
        return list;
    }
}
