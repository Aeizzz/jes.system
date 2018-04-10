package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysDomain;

import java.util.List;

/**
* 用户管理
* */
public interface SysDomainService extends EntityService<SysDomain>{
    List<SysDomain> queryAll();
}
