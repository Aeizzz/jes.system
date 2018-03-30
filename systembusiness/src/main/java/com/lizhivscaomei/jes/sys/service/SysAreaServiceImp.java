package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysArea;
import com.lizhivscaomei.jes.sys.dao.SysAreaMapper;
import com.lizhivscaomei.jes.sys.entity.SysAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysAreaServiceImp implements SysAreaService {
    @Autowired
    SysAreaMapper sysAreaMapper;

    public void add(SysArea entity) throws AppException {
        if(entity!=null){
            this.sysAreaMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysArea entity) throws AppException {
        this.sysAreaMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysAreaMapper.deleteByPrimaryKey(id);
    }

    public SysArea getById(String id) {
        return this.sysAreaMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysArea> queryPage(SysArea entity, Page page) {
        SysAreaExample example=new SysAreaExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysArea> list= this.sysAreaMapper.selectByExample(example);
        return new PageInfo<SysArea>(list);
    }
}
