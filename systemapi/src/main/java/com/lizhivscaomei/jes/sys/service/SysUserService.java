package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;

import java.util.List;

/**
 * 用户管理
 */
public interface SysUserService extends EntityService<SysUser> {

    /*根据登录名获取用户信息*/
    SysUser getByLoginName(String loginName) throws AppException;

    /*根据邮箱地址获取用户信息*/
    SysUser getByEmail(String email) throws AppException;

    /*根据手机号获取用户信息*/
    SysUser getByPhone(String phone) throws AppException;

    /*用户自主注册*/
    void regist(SysUser sysUser) throws AppException;

    /*自己修改密码*/
    void changePassword(String userid, String newPassword, String oldPassword) throws AppException;

    /*重置密码*/
    void resetPassword(String userid) throws AppException;

    /*查询所有用户*/
    List<SysUser> queryAll();
}
