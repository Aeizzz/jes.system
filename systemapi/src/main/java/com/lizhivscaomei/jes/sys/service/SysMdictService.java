package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysMdict;

import java.util.List;

/**
* 用户管理
* */
public interface SysMdictService extends EntityService<SysMdict>{
    /**
     * 获取子节点
     * @param pid 上级ID
     * */
    List<SysMdict> getChilds(String pid);
    /**
     * 获取子节点
     * @param pcode 上级code
     * */
    List<SysMdict> getChildsByCode(String pcode);
    /**
     * 获取节点
     * @param pcode 上级code
     * @param code 字典值code
     * */
    SysMdict getChildsByCode(String pcode,String code);
    /**
     * 获取节点
     * @param pcode 上级code
     * */
    SysMdict getParentByCode(String pcode);
}
