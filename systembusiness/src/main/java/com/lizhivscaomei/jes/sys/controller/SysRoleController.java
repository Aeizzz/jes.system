package com.lizhivscaomei.jes.sys.controller;


import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.entity.SpinnerVo;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.entity.SysUserRole;
import com.lizhivscaomei.jes.sys.service.SysMenuService;
import com.lizhivscaomei.jes.sys.service.SysRoleService;
import com.lizhivscaomei.jes.sys.service.SysUserService;
import com.lizhivscaomei.jes.sys.view.SysMenuTreeViewService;
import com.lizhivscaomei.jes.sys.view.SysRoleViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleViewService sysRoleViewService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysMenuTreeViewService sysMenuTreeViewService;
    /**
     * 保存
     * */
    @ResponseBody
    @RequestMapping("/sysRole/save")
    public Msg add(SysRole entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                this.sysRoleService.update(entity);
            }else {
                this.sysRoleService.add(entity);
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
    @RequestMapping("/sysRole/delete")
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
     * 详情
     * */
    @ResponseBody
    @RequestMapping("/sysRole/query/detail")
    public Msg detail(String id){
        SysRole entity= this.sysRoleService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
     * 分页查询
     * */
    @ResponseBody
    @RequestMapping("/sysRole/query/page")
    public Msg update(SysRole entity, Page page){
        PageInfo<SysRole> pages = this.sysRoleService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }
    /*角色用户管理-查询所有用户以及已分配的用户*/
    @ResponseBody
    @RequestMapping("/sysRole/user/query")
    public Msg queryUserFortransfer(String roleId){
        Msg msg=new Msg();
        //查询所有用户
        List<SysUser> allUserList = this.sysUserService.queryAll();
        //查询已分配用户
        List<SysUser> selectedUserList=this.sysRoleService.getUsers(roleId);
        //格式化数据
        List<SpinnerVo> allSpinerList=new ArrayList<>();
        List<String> selectedSpinerList=new ArrayList<>();
        if(allUserList!=null&&allUserList.size()>0){

            for(SysUser user:allUserList){
                SpinnerVo spinnerVo=new SpinnerVo();
                spinnerVo.setId(user.getId());
                spinnerVo.setText(user.getName());
                allSpinerList.add(spinnerVo);
            }
        }
        if(selectedUserList!=null&&selectedUserList.size()>0){

            for(SysUser user:selectedUserList){
                selectedSpinerList.add(user.getId());
            }
        }
        msg.setSuccess(true);
        Map result=new HashMap();
        result.put("all",allSpinerList);
        result.put("selected",selectedSpinerList);
        msg.setData(result);
        return msg;

    }
    /*保存角色-用户*/
    @ResponseBody
    @RequestMapping("/sysRole/user/save")
    public Msg saveRoleUsers(String roleId,String selectedList){
        Msg msg=new Msg();
        if(StringUtils.isNotEmpty(roleId)){
            List<String> paramList=new ArrayList<>();
            if(StringUtils.isNotEmpty(selectedList)){
                String[] paramArray = selectedList.split(",");
                for(String param:paramArray){
                    paramList.add(param);
                }
            }
            try {
                this.sysRoleService.saveRoleUsers(roleId,paramList);
                msg.setSuccess(true);
            } catch (AppException e) {
                msg.setSuccess(false);
                msg.setInfo(e.getMessage());
            }
        }else {
            msg.setSuccess(false);
            msg.setInfo("参数错误");
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping("/sysRole/privilege/query")
    public Msg queryPrivilegeTree(String roleId){
        Msg msg=new Msg();
        SysRole role = this.sysRoleService.getById(roleId);
        if(role!=null){
            //所有的菜单
            List<SysMenu> list = this.sysMenuService.getAll(role.getDomainId());
            this.sysMenuTreeViewService.setTreeVoList(list);
            TreeVo treeVo = this.sysMenuTreeViewService.convertToTree();
            //已选择的菜单
            List<String> menuIdList=new ArrayList<>();
            List<SysMenu> menuList = this.sysRoleService.getMenusByRole(roleId);
            if(menuList!=null&&menuList.size()>0){
                for(SysMenu menu:menuList){
                    menuIdList.add(menu.getId());
                }
            }
            Map result=new HashMap();
            result.put("all",new TreeVo[]{treeVo});
            result.put("selected",menuIdList);
            msg.setSuccess(true);
            msg.setData(result);
        }else {
            msg.setSuccess(false);
            msg.setInfo("角色不存在");
        }
        return msg;
    }
    /*保存角色-权限*/
    @ResponseBody
    @RequestMapping("/sysRole/privilege/save")
    public Msg saveRolePrivileges(String roleId,String selectedList){
        Msg msg=new Msg();
        if(StringUtils.isNotEmpty(roleId)){
            List<String> paramList=new ArrayList<>();
            if(StringUtils.isNotEmpty(selectedList)){
                String[] paramArray = selectedList.split(",");
                for(String param:paramArray){
                    paramList.add(param);
                }
            }
            try {
                this.sysRoleService.saveRoleMenus(roleId,paramList);
                msg.setSuccess(true);
            } catch (AppException e) {
                msg.setSuccess(false);
                msg.setInfo(e.getMessage());
            }
        }else {
            msg.setSuccess(false);
            msg.setInfo("参数错误");
        }
        return msg;
    }

}

