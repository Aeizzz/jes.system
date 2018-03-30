package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMdict;

import java.util.List;

/**
* 用户管理
* */
public interface SysMdictService extends EntityService<SysMdict>{
    List<SysMdict> getChilds(String pid);
}
