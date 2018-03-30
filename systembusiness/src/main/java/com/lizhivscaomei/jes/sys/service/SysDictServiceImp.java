package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysDict;
import com.lizhivscaomei.jes.sys.dao.SysDictMapper;
import com.lizhivscaomei.jes.sys.entity.SysDictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysDictServiceImp implements SysDictService {
    @Autowired
    SysDictMapper sysDictMapper;

    public void add(SysDict entity) throws AppException {
        if(entity!=null){
            this.sysDictMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysDict entity) throws AppException {
        this.sysDictMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysDictMapper.deleteByPrimaryKey(id);
    }

    public SysDict getById(String id) {
        return this.sysDictMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysDict> queryPage(SysDict entity, Page page) {
        SysDictExample example=new SysDictExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysDict> list= this.sysDictMapper.selectByExample(example);
        return new PageInfo<SysDict>(list);
    }
}
