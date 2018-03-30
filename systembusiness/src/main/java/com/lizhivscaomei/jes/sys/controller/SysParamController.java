package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysParam;
import com.lizhivscaomei.jes.sys.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/param")
@RestController
public class SysParamController {
    @Autowired
    SysParamService sysParamService;

    /**
    * 添加
    * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/add")
    public Msg add(SysParam entity){
        Msg msg=new Msg();
        try {
            this.sysParamService.add(entity);
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
    public Msg update(SysParam entity){
        Msg msg=new Msg();
        try {
            this.sysParamService.update(entity);
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
            this.sysParamService.delete(id);
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
    public Msg update(SysParam entity, Page page){
        PageInfo<SysParam> pages = this.sysParamService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

