package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.*;
import com.lizhivscaomei.jes.sys.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public void add(SysRole entity) throws AppException {
        if(entity!=null){
            this.sysRoleMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysRole entity) throws AppException {
        this.sysRoleMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysRoleMapper.deleteByPrimaryKey(id);
    }

    public SysRole getById(String id) {
        return this.sysRoleMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysRole> queryPage(SysRole entity, Page page) {
        SysRoleExample example=new SysRoleExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysRole> list= this.sysRoleMapper.selectByExample(example);
        return new PageInfo<SysRole>(list);
    }

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

    public void saveRoleUsers(String s, List<String> list) throws AppException {
        //删除旧的
        SysUserRoleExample example=new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(s);
        this.sysUserRoleMapper.deleteByExample(example);
        //添加新的
        for(String userid:list){
            SysUserRole record=new SysUserRole();
            record.setRoleId(s);
            record.setUserId(userid);
            this.sysUserRoleMapper.insert(record);
        }
    }

    public List<SysMenu> getMenus(String s) {
        SysRoleMenuExample example=new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(s);
        List<SysRoleMenu> menuRoleList = this.sysRoleMenuMapper.selectByExample(example);
        List<String> menuidList=new ArrayList<String>();
        for(SysRoleMenu sysRoleMenu:menuRoleList){
            menuidList.add(sysRoleMenu.getMenuId());
        }
        SysMenuExample menuExample=new SysMenuExample();
        SysMenuExample.Criteria menuCriteria = menuExample.createCriteria();
        menuCriteria.andIdIn(menuidList);
        return this.sysMenuMapper.selectByExample(menuExample);
    }

    public List<SysUser> getUsers(String s) {
        SysUserRoleExample example=new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(s);
        List<SysUserRole> userRoleList = this.sysUserRoleMapper.selectByExample(example);
        List<String> useridList=new ArrayList<String>();
        for(SysUserRole sysUserRole:userRoleList){
            useridList.add(sysUserRole.getUserId());
        }
        SysUserExample userExample=new SysUserExample();
        SysUserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andIdIn(useridList);
        return this.sysUserMapper.selectByExample(userExample);
    }
}
