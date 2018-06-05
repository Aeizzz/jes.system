package com.lizhivscaomei.jes.sys.service;

import com.lizhivscaomei.jes.common.service.EntityService;
import com.lizhivscaomei.jes.sys.entity.SysDict;

import java.util.List;

public interface SysDictService extends EntityService<SysDict>{

    /**
     * 查询所有
     * @param domainId 域的id
     * */
    List<SysDict> getAll(String domainId);

    /**
     * 查询字典值
     * @param domainId 域的id
     * @param pid 父节点ID
     * */
    List<SysDict> getChilds(String domainId, String pid);

    /**
     * 获取字典值
     * @param domainId 域的id
     * @param pcode 上级code
     * */
    List<SysDict> getChildsByCode(String domainId, String pcode);

    /**
     * 获取字典分类
     * @param domainId 域的id
     * @param code 分类code
     * */
    SysDict getCategoryByCode(String domainId, String code);

    /**
     * 获取字典值
     * @param domainId 域的id
     * @param pcode 上级code
     * @param code 字典值code
     * */
    SysDict getChildByCode(String domainId, String pcode,String code);
}
