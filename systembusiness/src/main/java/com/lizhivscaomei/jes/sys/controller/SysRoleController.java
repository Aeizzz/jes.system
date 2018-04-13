package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.plugins.datatables.DataTablesRequest;
import com.lizhivscaomei.jes.plugins.datatables.DataTablesResponse;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.service.SysRoleService;
import com.lizhivscaomei.jes.sys.view.SysRoleViewService;
import com.lizhivscaomei.jes.sys.view.SysRoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleViewService sysRoleViewService;
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
    public DataTablesResponse<SysRoleVo> update(SysRole entity, DataTablesRequest dataTablesRequest){
        DataTablesResponse<SysRoleVo> response=new DataTablesResponse<>();
        response.setDraw(dataTablesRequest.getDraw());
        Page page=new Page();
        page.setCurrentPage(dataTablesRequest.getStart());
        page.setPageSize(dataTablesRequest.getLength());
        PageInfo<SysRole> pages = this.sysRoleService.queryPage(entity, page);
        response.setData(this.sysRoleViewService.dtoList2voList(pages.getList()));
        response.setRecordsTotal(pages.getTotal());
        return response;

    }

}

