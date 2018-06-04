package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMenu;

import java.util.List;

/**
* 用户管理
* */
public interface SysMenuService extends EntityService<SysMenu>{

    /*查询子菜单*/
    List<SysMenu> getChilds(String domainId,String pid);

    /*查询所有*/
    List<SysMenu> getAll(String domainId);

    /*查询某个用户特定域下的菜单*/
    List<SysMenu> getByUserAndDomain(String userId,String domainId);
}
