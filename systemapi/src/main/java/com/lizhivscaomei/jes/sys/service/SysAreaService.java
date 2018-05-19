package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysArea;

import java.util.List;

/**
* 用户管理
* */
public interface SysAreaService extends EntityService<SysArea>{
    List<SysArea> getAll();
}
