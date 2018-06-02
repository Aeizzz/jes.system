package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;

import java.util.List;

/**
* 用户管理
* */
public interface SysUserService extends EntityService<SysUser>{
    /*用户登录*/
    SysUser getByLoginName(String loginName) throws AppException;
    SysUser getEmail(String email) throws AppException;
    SysUser getPhone(String phone) throws AppException;
    /*用户注册*/
    void regist(SysUser sysUser) throws AppException;
    /*修改密码*/
    void changePassword(String userid,String newPassword,String oldPassword) throws AppException;
    /*重置密码*/
    void resetPassword(String userid,String newPassword) throws AppException;
    /*获取用户的角色*/
    List<SysRole> getMyRoles(String userid);
    /*获取用户的授权菜单*/
    @Deprecated
    List<SysMenu> getMyMenus(String userid);
    /*查询所有用户*/
    List<SysUser> queryAll();
}
