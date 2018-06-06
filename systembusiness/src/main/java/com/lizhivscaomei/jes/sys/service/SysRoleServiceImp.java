package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.*;
import com.lizhivscaomei.jes.sys.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysRoleServiceImp implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    @Transactional
    public void add(SysRole entity) throws AppException {
        if(entity!=null){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
            //默认数据
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            entity.setDelFlag("0");
            this.sysRoleMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    @Override
    @Transactional
    public void update(SysRole entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysRoleMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional
    public void delete(String id) throws AppException {
        this.sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SysRole getById(String id) {
        return this.sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<SysRole> queryPage(SysRole entity, Page page) {
        SysRoleExample example=new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andDomainIdEqualTo(entity.getDomainId());
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysRole> list= this.sysRoleMapper.selectByExample(example);
        return new PageInfo<SysRole>(list);
    }

    @Override
    @Transactional
    public void saveRoleMenus(String s, List<String> list) throws AppException {
        //删除旧的
        SysRoleMenuExample example=new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(s);
        this.sysRoleMenuMapper.deleteByExample(example);
        //添加新的
        for(String menuid:list){
            SysRoleMenu record=new SysRoleMenu();
            record.setMenuId(menuid);
            record.setRoleId(s);
            this.sysRoleMenuMapper.insert(record);
        }
    }

    @Override
    @Transactional
    public void saveRoleUsers(String s, List<String> list) throws AppException {
        //删除旧的
        SysUserRoleExample example=new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(s);
        this.sysUserRoleMapper.deleteByExample(example);
        if(list!=null&&list.size()>0){
            //添加新的
            for(String userid:list){
                SysUserRole record=new SysUserRole();
                record.setRoleId(s);
                record.setUserId(userid);
                this.sysUserRoleMapper.insert(record);
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenu> getMenusByRole(String roleId) {
        SysRoleMenuExample example=new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<SysRoleMenu> menuRoleList = this.sysRoleMenuMapper.selectByExample(example);
        if(menuRoleList!=null&&menuRoleList.size()>0){
            List<String> menuidList=new ArrayList<String>();
            for(SysRoleMenu sysRoleMenu:menuRoleList){
                menuidList.add(sysRoleMenu.getMenuId());
            }
            SysMenuExample menuExample=new SysMenuExample();
            SysMenuExample.Criteria menuCriteria = menuExample.createCriteria();
            menuCriteria.andIdIn(menuidList);
            return this.sysMenuMapper.selectByExample(menuExample);
        }else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysUser> getUsers(String s) {
        SysUserRoleExample example=new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(s);
        List<SysUserRole> userRoleList = this.sysUserRoleMapper.selectByExample(example);
        if(userRoleList!=null&&userRoleList.size()>0){
            List<String> useridList=new ArrayList<String>();
            for(SysUserRole sysUserRole:userRoleList){
                useridList.add(sysUserRole.getUserId());
            }
            SysUserExample userExample=new SysUserExample();
            SysUserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andIdIn(useridList);
            return this.sysUserMapper.selectByExample(userExample);
        }else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysUserRole> getRolesByUser(String userid) {
        SysUserRoleExample example=new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
       return this.sysUserRoleMapper.selectByExample(example);
    }

}
