package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysParam;
import com.lizhivscaomei.jes.sys.dao.SysParamMapper;
import com.lizhivscaomei.jes.sys.entity.SysParamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysParamServiceImp implements SysParamService {
    @Autowired
    SysParamMapper sysParamMapper;

    public void add(SysParam entity) throws AppException {
        if(entity!=null){
            this.sysParamMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysParam entity) throws AppException {
        this.sysParamMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysParamMapper.deleteByPrimaryKey(id);
    }

    public SysParam getById(String id) {
        return this.sysParamMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysParam> queryPage(SysParam entity, Page page) {
        SysParamExample example=new SysParamExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysParam> list= this.sysParamMapper.selectByExample(example);
        return new PageInfo<SysParam>(list);
    }
}
