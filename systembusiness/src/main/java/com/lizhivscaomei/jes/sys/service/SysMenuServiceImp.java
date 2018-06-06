package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.utils.JavaBeanUtil;
import com.lizhivscaomei.jes.sys.dao.SysUserRoleMapper;
import com.lizhivscaomei.jes.sys.dao.VSysUserDomainMenuMapper;
import com.lizhivscaomei.jes.sys.entity.*;
import com.lizhivscaomei.jes.sys.dao.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysMenuServiceImp implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    VSysUserDomainMenuMapper vSysUserDomainMenuMapper;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void update(SysMenu entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysMenuMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional
    public void delete(String id) throws AppException {
        this.sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SysMenu getById(String id) {
        return this.sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysMenu> queryPage(SysMenu entity, Page page) {
        SysMenuExample example=new SysMenuExample();
        example.setOrderByClause("sort");
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(entity.getDomainId());
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysMenu> list= this.sysMenuMapper.selectByExample(example);
        return new PageInfo<SysMenu>(list);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> getChilds(String domainId, String pid) {
        SysMenuExample example=new SysMenuExample();
        example.setOrderByClause("sort");
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        criteria.andDomainIdEqualTo(domainId);
        return this.sysMenuMapper.selectByExample(example);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> getAll(String domainId) {
        SysMenuExample example=new SysMenuExample();
        example.setOrderByClause("sort");
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(domainId);
        List<SysMenu> list = this.sysMenuMapper.selectByExample(example);
        SysMenu root=new SysMenu();
        root.setId("-1");
        root.setName("顶级菜单");
        list.add(root);
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> getByUserAndDomain(String userId, String domainId) {
        List<SysMenu> sysMenuList=new ArrayList<>();
        VSysUserDomainMenuExample example=new VSysUserDomainMenuExample();
        example.setOrderByClause("sort");
        VSysUserDomainMenuExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDomainIdEqualTo(domainId);
        List<VSysUserDomainMenu> list = this.vSysUserDomainMenuMapper.selectByExample(example);
        for(VSysUserDomainMenu vSysUserDomainMenu:list){
            SysMenu sysMenu=new SysMenu();
            try {
                JavaBeanUtil.javaBean2JavaBean(vSysUserDomainMenu,sysMenu);
                if(!sysMenuList.contains(sysMenu)){
                    sysMenuList.add(sysMenu);
                }
            } catch (IntrospectionException e) {
//                e.printStackTrace();
            }
        }
        return sysMenuList;
    }

}
