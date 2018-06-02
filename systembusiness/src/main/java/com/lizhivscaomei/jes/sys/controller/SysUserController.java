package com.lizhivscaomei.jes.sys.controller;


import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;
    /**
    * 保存
    * */
    @ResponseBody
    @RequestMapping("/sysUser/save")
//    @PreAuthorize(value = "hasAuthority('sys.usercenter.user')")
    public Msg add(SysUser entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                entity.setUpdateBy("");
                this.sysUserService.update(entity);
            }else {
                entity.setCreateBy("");
                entity.setUpdateBy("");
                this.sysUserService.add(entity);
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
    @RequestMapping("/sysUser/delete")
    public Msg update(String id){
        Msg msg=new Msg();
        try {
            this.sysUserService.delete(id);
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
    @RequestMapping("/sysUser/query/detail")
    public Msg detail(String id){
        SysUser entity= this.sysUserService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
    * 分页查询
    * */
    @ResponseBody
    @RequestMapping("/sysUser/query/page")
    public Msg update(SysUser entity, Page page){
        PageInfo<SysUser> pages = this.sysUserService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

