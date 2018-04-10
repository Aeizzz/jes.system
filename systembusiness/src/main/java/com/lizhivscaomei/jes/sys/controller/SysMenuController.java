package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.plugins.datatables.DataTablesRequest;
import com.lizhivscaomei.jes.plugins.datatables.DataTablesResponse;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

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
    * 分页查询
    * */
    @ResponseBody
    @RequestMapping("/sysMenu/query/page")
    public DataTablesResponse<SysMenu> update(SysMenu entity, DataTablesRequest dataTablesRequest){
        DataTablesResponse<SysMenu> response=new DataTablesResponse<>();
        response.setDraw(dataTablesRequest.getDraw());
        Page page=new Page();
        page.setCurrentPage(dataTablesRequest.getStart());
        page.setPageSize(dataTablesRequest.getLength());
        PageInfo<SysMenu> pages = this.sysMenuService.queryPage(entity, page);
        response.setData(pages.getList());
        response.setRecordsTotal(pages.getTotal());
        return response;

    }

}

