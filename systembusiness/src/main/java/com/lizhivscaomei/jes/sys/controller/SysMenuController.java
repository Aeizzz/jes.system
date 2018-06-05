package com.lizhivscaomei.jes.sys.controller;


import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.service.SysMenuService;
import com.lizhivscaomei.jes.sys.view.SysMenuTreeViewService;
import com.lizhivscaomei.jes.sys.view.SysMenuViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysMenuViewService sysMenuViewService;
    @Autowired
    SysMenuTreeViewService sysMenuTreeViewService;
    /**
    * 保存
    * */
    @ResponseBody
    @RequestMapping("/sysMenu/save")
    public Msg add(SysMenu entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                this.sysMenuService.update(entity);
            }else {
                this.sysMenuService.add(entity);
            }
            msg.setSuccess(true);
        } catch (AppException e) {
            msg.setSuccess(false);
            msg.setInfo(e.getMessage());
        }
        return msg;
    }

    /**
    * 删除
    * */
    @ResponseBody
    @RequestMapping("/sysMenu/delete")
    public Msg update(String id){
        Msg msg=new Msg();
        try {
            this.sysMenuService.delete(id);
            msg.setSuccess(true);
        } catch (AppException e) {
            msg.setSuccess(false);
            msg.setInfo(e.getMessage());
        }
        return msg;
    }

    /**
    * 详情
    * */
    @ResponseBody
    @RequestMapping("/sysMenu/query/detail")
    public Msg detail(String id){
        SysMenu entity= this.sysMenuService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
    * 树形选择
    * */
    @ResponseBody
    @RequestMapping("/sysMenu/query/select")
    public Msg select(String domainId){
        List<SysMenu> list = this.sysMenuService.getAll(domainId);
        this.sysMenuTreeViewService.setTreeVoList(list);
        TreeVo treeVo = this.sysMenuTreeViewService.convertToTree();
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(new TreeVo[]{treeVo});
        return msg;

    }
    /**
    * 分页查询
    * */
    @ResponseBody
    @RequestMapping("/sysMenu/query/page")
    public Msg update(SysMenu entity, Page page){
        PageInfo<SysMenu> pages = this.sysMenuService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

