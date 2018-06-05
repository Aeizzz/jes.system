package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysMdict;
import com.lizhivscaomei.jes.sys.dao.SysMdictMapper;
import com.lizhivscaomei.jes.sys.entity.SysMdictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysMdictServiceImp implements SysMdictService {
    @Autowired
    SysMdictMapper sysMdictMapper;

    public void add(SysMdict entity) throws AppException {
        if(entity!=null){
            this.sysMdictMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysMdict entity) throws AppException {
        this.sysMdictMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysMdictMapper.deleteByPrimaryKey(id);
    }

    public SysMdict getById(String id) {
        return this.sysMdictMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysMdict> queryPage(SysMdict entity, Page page) {
        SysMdictExample example=new SysMdictExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysMdict> list= this.sysMdictMapper.selectByExample(example);
        return new PageInfo<SysMdict>(list);
    }

    public List<SysMdict> getChilds(String s) {
        SysMdictExample example=new SysMdictExample();
        SysMdictExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdsEqualTo(s);
        return this.sysMdictMapper.selectByExample(example);
    }

    @Override
    public List<SysMdict> getChildsByCode(String pcode) {
        //获取父节点
        //根据父节点的ID获取子节点
        throw new RuntimeException("未完成");
    }

    @Override
    public SysMdict getChildsByCode(String pcode, String code) {
        //获取父节点
        //根据父节点的ID和code获取
        throw new RuntimeException("未完成");
    }

    @Override
    public SysMdict getParentByCode(String pcode) {
        throw new RuntimeException("未完成");
    }
}
