package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysOffice;
import com.lizhivscaomei.jes.sys.dao.SysOfficeMapper;
import com.lizhivscaomei.jes.sys.entity.SysOfficeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysOfficeServiceImp implements SysOfficeService {
    @Autowired
    SysOfficeMapper sysOfficeMapper;

    public void add(SysOffice entity) throws AppException {
        if(entity!=null){
            this.sysOfficeMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysOffice entity) throws AppException {
        this.sysOfficeMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysOfficeMapper.deleteByPrimaryKey(id);
    }

    public SysOffice getById(String id) {
        return this.sysOfficeMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysOffice> queryPage(SysOffice entity, Page page) {
        SysOfficeExample example=new SysOfficeExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysOffice> list= this.sysOfficeMapper.selectByExample(example);
        return new PageInfo<SysOffice>(list);
    }

    public List<SysOffice> getChilds(String s) {
        SysOfficeExample example=new SysOfficeExample();
        SysOfficeExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(s);
        return this.sysOfficeMapper.selectByExample(example);
    }
}
