package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysArea;
import com.lizhivscaomei.jes.sys.entity.SysDict;
import com.lizhivscaomei.jes.sys.service.SysAreaService;
import com.lizhivscaomei.jes.sys.view.SysAreaTreeViewService;
import com.lizhivscaomei.jes.sys.view.SysDictTreeViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysAreaController {
    @Autowired
    SysAreaService sysAreaService;
    @Autowired
    SysAreaTreeViewService sysAreaTreeViewService;
    /**
    * 保存
    * */
    @ResponseBody
    @RequestMapping("/sysArea/save")
    public Msg add(SysArea entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                this.sysAreaService.update(entity);
            }else {
                this.sysAreaService.add(entity);
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
    @RequestMapping("/sysArea/delete")
    public Msg update(String id){
        Msg msg=new Msg();
        try {
            this.sysAreaService.delete(id);
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
    @RequestMapping("/sysArea/query/detail")
    public Msg detail(String id){
        SysArea entity= this.sysAreaService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
     * 树形选择
     * */
    @ResponseBody
    @RequestMapping("/sysArea/query/select")
    public Msg select(SysArea entity, Page page){
        List<SysArea> list = this.sysAreaService.getAll();
        this.sysAreaTreeViewService.setTreeVoList(list);
        TreeVo treeVo = this.sysAreaTreeViewService.convertToTree();
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(new TreeVo[]{treeVo});
        return msg;

    }
    /**
    * 分页查询
    * */
    @ResponseBody
    @RequestMapping("/sysArea/query/page")
    public Msg update(SysArea entity, Page page){
        PageInfo<SysArea> pages = this.sysAreaService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

