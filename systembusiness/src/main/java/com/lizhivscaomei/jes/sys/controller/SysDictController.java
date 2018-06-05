package com.lizhivscaomei.jes.sys.controller;


import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysDict;
import com.lizhivscaomei.jes.sys.service.SysDictService;
import com.lizhivscaomei.jes.sys.view.SysDictTreeViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysDictController {
    @Autowired
    SysDictService sysDictService;
    @Autowired
    SysDictTreeViewService sysDictTreeViewService;
    /**
    * 保存
    * */
    @ResponseBody
    @RequestMapping("/sysDict/save")
    public Msg add(SysDict entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                this.sysDictService.update(entity);
            }else {
                this.sysDictService.add(entity);
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
    @RequestMapping("/sysDict/delete")
    public Msg update(String id){
        Msg msg=new Msg();
        try {
            this.sysDictService.delete(id);
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
    @RequestMapping("/sysDict/query/detail")
    public Msg detail(String id){
        SysDict entity= this.sysDictService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
     * 详情
     * */
    @ResponseBody
    @RequestMapping("/sysDict/query/select")
    public Msg select(String domainId){
        List<SysDict> list = this.sysDictService.getAll(domainId);
        SysDict root=new SysDict();
        root.setId("0");
        root.setCode("ROOT");
        root.setName("根");
        list.add(root);
        this.sysDictTreeViewService.setTreeVoList(list);
        TreeVo treeVo = this.sysDictTreeViewService.convertToTree();
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(new TreeVo[]{treeVo});
        return msg;

    }
    /**
    * 分页查询
    * */
    @ResponseBody
    @RequestMapping("/sysDict/query/page")
    public Msg update(SysDict entity, Page page){
        PageInfo<SysDict> pages = this.sysDictService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

