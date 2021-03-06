package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysParam;

/**
* 用户管理
* */
public interface SysParamService extends EntityService<SysParam>{
    /*根据参数编码查询参数*/
    SysParam getByCode(String code);
}
