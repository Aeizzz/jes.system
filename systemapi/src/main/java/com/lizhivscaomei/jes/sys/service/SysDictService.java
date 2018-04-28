package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysDict;

import java.util.List;

public interface SysDictService extends EntityService<SysDict>{
    /*查询子菜单*/
    List<SysDict> getChilds(String domainId, String pid);
    /*查询所有*/
    List<SysDict> getAll(String domainId);
}
