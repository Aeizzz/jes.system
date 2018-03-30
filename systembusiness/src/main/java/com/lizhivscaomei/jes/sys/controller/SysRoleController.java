package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/role")
@RestController
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;

    /**
    * 添加
    * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/add")
    public Msg add(SysRole entity){
        Msg msg=new Msg();
        try {
            this.sysRoleService.add(entity);
            msg.setSuccess(true);
        } catch (AppException e) {
            msg.setSuccess(false);
            msg.setInfo(e.getMessage());
        }
        return msg;
    }
    /**
    * 修改
    * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/update")
    public Msg update(SysRole entity){
        Msg msg=new Msg();
        try {
            this.sysRoleService.update(entity);
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
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/delete")
    public Msg update(String id){
        Msg msg=new Msg();
        try {
            this.sysRoleService.delete(id);
            msg.setSuccess(true);
        } catch (AppException e) {
            msg.setSuccess(false);
            msg.setInfo(e.getMessage());
        }
        return msg;
    }
    /**
     * 分页查询
     * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/query/page")
    public Msg update(SysRole entity, Page page){
        PageInfo<SysRole> pages = this.sysRoleService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }
    /**
     * 查询角色下的用户
     * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/query/page/users")
    public Msg queryUsers(String id){
        List<SysUser> data = this.sysRoleService.getUsers(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(data);
        return msg;

    }
    /**
     * 查询角色下的菜单
     * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/query/page/menus")
    public Msg queryMenus(String id){
        List<SysMenu> data = this.sysRoleService.getMenus(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(data);
        return msg;

    }

}

