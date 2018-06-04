package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysDomain;
import com.lizhivscaomei.jes.sys.entity.VSysUserRoleDomain;

import java.util.List;

/**
* 用户管理
* */
public interface SysDomainService extends EntityService<SysDomain>{
    //查询所有的域
    List<SysDomain> queryAll();
    //查询用户可以访问的域
    List<VSysUserRoleDomain> getByUser(String userId);
}
