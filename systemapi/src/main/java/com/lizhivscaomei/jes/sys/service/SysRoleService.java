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
public interface SysRoleService extends EntityService<SysRole>{
    void saveRoleMenus(String roleid, List<String> menuidList) throws AppException;
    void saveRoleUsers(String roleid, List<String> useridList) throws AppException;
    List<SysMenu> getMenus(String roleid);
    List<SysUser> getUsers(String roleid);
}
