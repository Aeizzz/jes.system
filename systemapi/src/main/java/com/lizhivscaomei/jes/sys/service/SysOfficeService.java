package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysOffice;

import java.util.List;

/**
* 用户管理
* */
public interface SysOfficeService extends EntityService<SysOffice>{
    List<SysOffice> getChilds(String pid);
}
