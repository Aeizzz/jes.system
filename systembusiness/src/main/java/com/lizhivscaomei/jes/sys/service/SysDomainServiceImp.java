package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysDomain;
import com.lizhivscaomei.jes.sys.dao.SysDomainMapper;
import com.lizhivscaomei.jes.sys.entity.SysDomainExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysDomainServiceImp implements SysDomainService {
    @Autowired
    SysDomainMapper sysDomainMapper;

    public void add(SysDomain entity) throws AppException {
        if(entity!=null){
            this.sysDomainMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysDomain entity) throws AppException {
        this.sysDomainMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysDomainMapper.deleteByPrimaryKey(id);
    }

    public SysDomain getById(String id) {
        return this.sysDomainMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysDomain> queryPage(SysDomain entity, Page page) {
        SysDomainExample example=new SysDomainExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysDomain> list= this.sysDomainMapper.selectByExample(example);
        return new PageInfo<SysDomain>(list);
    }
}
