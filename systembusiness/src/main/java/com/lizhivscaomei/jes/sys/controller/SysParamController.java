package com.lizhivscaomei.jes.sys.controller;


import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysParam;
import com.lizhivscaomei.jes.sys.service.SysParamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysParamController {
    @Autowired
    SysParamService sysParamService;

    /**
    * 保存
    * */
    @ResponseBody
    @RequestMapping("/sysParam/save")
    public Msg add(SysParam entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                this.sysParamService.update(entity);
            }else {
                this.sysParamService.add(entity);
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
    @RequestMapping("/sysParam/delete")
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
    * 详情
    * */
    @ResponseBody
    @RequestMapping("/sysParam/query/detail")
    public Msg detail(String id){
        SysParam entity= this.sysParamService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
    * 分页查询
    * */
    @ResponseBody
    @RequestMapping("/sysParam/query/page")
    public Msg update(SysParam entity, Page page){
        PageInfo<SysParam> pages = this.sysParamService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

