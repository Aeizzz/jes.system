package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.SysUserMapper;
import com.lizhivscaomei.jes.sys.dao.SysUserRoleMapper;
import com.lizhivscaomei.jes.sys.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImp implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysParamService sysParamService;

    /**
     * 添加用户
     * 只能是默认密码
     */
    public void add(SysUser entity) throws AppException {
        if (entity != null) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //默认数据
            entity.setPassword("123456");
            entity.setId(UUID.randomUUID().toString());
            entity.setCreateBy(userDetails.getUsername());
            entity.setCreateDate(new Date());
            entity.setUpdateBy(userDetails.getUsername());
            entity.setUpdateDate(new Date());
            entity.setDelFlag("0");
            this.sysUserMapper.insertSelective(entity);
        } else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysUser entity) throws AppException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setUpdateBy(userDetails.getUsername());
        entity.setUpdateDate(new Date());
        this.sysUserMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysUserMapper.deleteByPrimaryKey(id);
    }

    public SysUser getById(String id) {
        return this.sysUserMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysUser> queryPage(SysUser entity, Page page) {
        SysUserExample example = new SysUserExample();
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        return new PageInfo<SysUser>(list);
    }

    public SysUser getByLoginName(String s) throws AppException {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo(s);
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public SysUser getByEmail(String s) throws AppException {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(s);
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public SysUser getByPhone(String s) throws AppException {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(s);
        List<SysUser> list = this.sysUserMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 用户注册
     * 用户自定义密码
     */
    public void regist(SysUser sysUser) throws AppException {

    }

    @Override
    public void changePassword(String userid, String newPassword, String oldPassword) throws AppException {

    }

    @Override
    public void resetPassword(String userid) throws AppException {
        if(StringUtils.isNotEmpty(userid)){
            SysParam defaultPwd = this.sysParamService.getByCode("SYS_DEF_PWD");
            if(defaultPwd!=null&& StringUtils.isNotEmpty(defaultPwd.getValue())){
                SysUser record=new SysUser();
                record.setId(userid);
                record.setPassword(defaultPwd.getValue());
                this.sysUserMapper.updateByPrimaryKeySelective(record);
            }else {
                throw new AppException("系统尚未设置默认密码");
            }
        }else{
            throw new AppException("参数错误");
        }
    }

    @Override
    public List<SysUser> queryAll() {
        SysUserExample example = new SysUserExample();
        example.setOrderByClause("login_name asc");
        return this.sysUserMapper.selectByExample(example);
    }
}
