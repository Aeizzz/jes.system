package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.dao.SysMenuMapper;
import com.lizhivscaomei.jes.sys.entity.SysMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysMenuServiceImp implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    public void add(SysMenu entity) throws AppException {
        if(entity!=null){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            //默认数据
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            entity.setDelFlag("0");
            this.sysMenuMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysMenu entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysMenuMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysMenuMapper.deleteByPrimaryKey(id);
    }

    public SysMenu getById(String id) {
        return this.sysMenuMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysMenu> queryPage(SysMenu entity, Page page) {
        SysMenuExample example=new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(entity.getDomainId());
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysMenu> list= this.sysMenuMapper.selectByExample(example);
        return new PageInfo<SysMenu>(list);
    }

    @Override
    public List<SysMenu> getChilds(String domainId, String pid) {
        SysMenuExample example=new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        criteria.andDomainIdEqualTo(domainId);
        return this.sysMenuMapper.selectByExample(example);
    }

    @Override
    public List<SysMenu> getAll(String domainId) {
        SysMenuExample example=new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        List<SysMenu> list = this.sysMenuMapper.selectByExample(example);
        SysMenu root=new SysMenu();
        root.setId("-1");
        root.setName("顶级菜单");
        list.add(root);
        return list;
    }
}
