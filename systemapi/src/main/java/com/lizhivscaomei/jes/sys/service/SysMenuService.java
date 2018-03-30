package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMenu;

import java.util.List;

/**
* 用户管理
* */
public interface SysMenuService extends EntityService<SysMenu>{
    /*查询子菜单*/
    List<SysMenu> getChilds(String pid);
}
