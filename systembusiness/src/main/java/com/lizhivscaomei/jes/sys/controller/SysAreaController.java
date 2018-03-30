package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysArea;
import com.lizhivscaomei.jes.sys.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/area")
@RestController
public class SysAreaController {
    @Autowired
    SysAreaService sysAreaService;

    /**
    * 添加
    * */
    @ResponseBody
    @RequestMapping("/com/lizhivscaomei/jes/sys/controller/add")
    public Msg add(SysArea entity){
        Msg msg=new Msg();
        try {
            this.sysAreaService.add(entity);
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
    public Msg update(SysArea entity){
        Msg msg=new Msg();
        try {
            this.sysAreaService.update(entity);
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
            this.sysAreaService.delete(id);
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
    public Msg update(SysArea entity, Page page){
        PageInfo<SysArea> pages = this.sysAreaService.queryPage(entity, page);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(pages);
        return msg;

    }

}

