package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysOffice;
import com.lizhivscaomei.jes.sys.service.SysOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/office")
@RestController
public class SysOfficeController {
    @Autowired
    SysOfficeService sysOfficeService;

    /**
    * 添加
    * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/add")
    public Msg add(SysOffice entity){
        Msg msg=new Msg();
        try {
            this.sysOfficeService.add(entity);
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
    public Msg update(SysOffice entity){
        Msg msg=new Msg();
        try {
            this.sysOfficeService.update(entity);
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
            this.sysOfficeService.delete(id);
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
    public Msg query(SysOffice entity, Page page){
        PageInfo<SysOffice> pages = this.sysOfficeService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

