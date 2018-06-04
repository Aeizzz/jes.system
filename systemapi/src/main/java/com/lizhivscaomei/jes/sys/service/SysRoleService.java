package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.entity.SysUserRole;

import java.util.List;

/**
* 用户管理
* */
public interface SysRoleService extends EntityService<SysRole>{

    /*保存角色与菜单的对应关系*/
    void saveRoleMenus(String roleid, List<String> menuidList) throws AppException;

    /*保存角色和用户的对应关系*/
    void saveRoleUsers(String roleid, List<String> useridList) throws AppException;

    /*获取角色对应的菜单*/
    List<SysMenu> getMenusByRole(String roleid);

    /*获取改角色下有多少用户*/
    List<SysUser> getUsers(String roleid);

    /*获取用户对应的角色*/
    List<SysUserRole> getRolesByUser(String userid);

    /*获取用户在某个域下对应的角色*/
    List<SysRole> getRolesByUserAndDomain(String userid,String domainId);
}
