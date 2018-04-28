package com.lizhivscaomei.jes.sys.controller;



import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.entity.SpinnerVo;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.plugins.datatables.DataTablesRequest;
import com.lizhivscaomei.jes.plugins.datatables.DataTablesResponse;
import com.lizhivscaomei.jes.sys.entity.SysDomain;
import com.lizhivscaomei.jes.sys.service.SysDomainService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/com/lizhivscaomei/jes/sys/controller")
public class SysDomainController {
    @Autowired
    SysDomainService sysDomainService;

    /**
     * 保存
     * */
    @ResponseBody
    @RequestMapping("/sysDomain/save")
    public Msg add(SysDomain entity){
        Msg msg=new Msg();
        try {
            if(StringUtils.isNotEmpty(entity.getId())){
                this.sysDomainService.update(entity);
            }else {
                this.sysDomainService.add(entity);
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
    @RequestMapping("/sysDomain/delete")
    public Msg update(String id){
        Msg msg=new Msg();
        try {
            this.sysDomainService.delete(id);
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
    @RequestMapping("/sysDomain/query/detail")
    public Msg detail(String id){
        SysDomain entity= this.sysDomainService.getById(id);
        Msg msg=new Msg();
        msg.setSuccess(true);
        msg.setData(entity);
        return msg;

    }
    /**
     * 分页查询
     * */
    @ResponseBody
    @RequestMapping("/sysDomain/query/page")
    public DataTablesResponse<SysDomain> update(SysDomain entity, DataTablesRequest dataTablesRequest){
        DataTablesResponse<SysDomain> response=new DataTablesResponse<>();
        response.setDraw(dataTablesRequest.getDraw());
        Page page=new Page();
        page.setCurrentPage(dataTablesRequest.getStart());
        page.setPageSize(dataTablesRequest.getLength());
        PageInfo<SysDomain> pages = this.sysDomainService.queryPage(entity, page);
        response.setData(pages.getList());
        response.setRecordsTotal(pages.getTotal());
        return response;

    }
    /**
     * 分页查询
     * */
    @ResponseBody
    @RequestMapping("/sysDomain/query/spinner")
    public List<SpinnerVo> spinner(SysDomain entity){
        List<SpinnerVo> spinnerVoList=new ArrayList<>();
        List<SysDomain> list = this.sysDomainService.queryAll();
        for(SysDomain sysDomain:list){
            SpinnerVo spinner=new SpinnerVo();
            spinner.setId(sysDomain.getId());
            spinner.setText(sysDomain.getName());
            spinnerVoList.add(spinner);
        }
        return spinnerVoList;

    }
}

