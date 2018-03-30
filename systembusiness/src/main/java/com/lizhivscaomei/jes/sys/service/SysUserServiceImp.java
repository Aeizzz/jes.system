package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.SysUserMapper;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.entity.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImp implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    /**
     * 添加用户
     * 只能是默认密码
     * */
    public void add(SysUser entity) throws AppException {
        if(entity!=null){
            this.sysUserMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysUser entity) throws AppException {
        this.sysUserMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysUserMapper.deleteByPrimaryKey(id);
    }

    public SysUser getById(String id) {
        return this.sysUserMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysUser> queryPage(SysUser entity, Page page) {
        SysUserExample example=new SysUserExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysUser> list= this.sysUserMapper.selectByExample(example);
        return new PageInfo<SysUser>(list);
    }

    public SysUser getByLoginName(String s) throws AppException {
        boolean test=true;
        if(test){
            SysUser sysUser=new SysUser();
            sysUser.setName("admin");
            sysUser.setPassword("admin");
            sysUser.setLoginName("admin");
            return sysUser;
        }
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(s);
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public SysUser getEmail(String s) throws AppException {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(s);
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public SysUser getPhone(String s) throws AppException {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(s);
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
    /**
     * 用户注册
     * 用户自定义密码
     * */
    public void regist(SysUser sysUser) throws AppException {

    }

    @Override
    public void changePassword(String userid, String newPassword, String oldPassword) throws AppException {

    }

    @Override
    public void resetPassword(String userid, String newPassword) throws AppException {

    }

    @Override
    public List<SysRole> getMyRoles(String userid) {
        List<SysRole> roleList=new ArrayList<>();
        SysRole role=new SysRole();
        role.setId(UUID.randomUUID().toString());
        role.setName("admin");
        roleList.add(role);
        return roleList;
    }

    @Override
    public List<SysMenu> getMyMenus(String userid) {
        List<SysMenu> menuList=new ArrayList<>();
        SysMenu sysMenu=new SysMenu();
        sysMenu.setId(UUID.randomUUID().toString());
        sysMenu.setName("用户管理");
        sysMenu.setHref("http://www.baidu.com");
        sysMenu.setPermission("user");
        menuList.add(sysMenu);
        return menuList;
    }
}
