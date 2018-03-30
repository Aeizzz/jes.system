package com.lizhivscaomei.jes.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhivscaomei.jes.common.entity.Page;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.dao.SysMenuMapper;
import com.lizhivscaomei.jes.sys.entity.SysMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysMenuServiceImp implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    public void add(SysMenu entity) throws AppException {
        if(entity!=null){
            this.sysMenuMapper.insertSelective(entity);
        }else {
            throw new AppException("entity不可为空");
        }
    }

    public void update(SysMenu entity) throws AppException {
        this.sysMenuMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(String id) throws AppException {
        this.sysMenuMapper.deleteByPrimaryKey(id);
    }

    public SysMenu getById(String id) {
        return this.sysMenuMapper.selectByPrimaryKey(id);
    }

    public PageInfo<SysMenu> queryPage(SysMenu entity, Page page) {
        SysMenuExample example=new SysMenuExample();
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysMenu> list= this.sysMenuMapper.selectByExample(example);
        return new PageInfo<SysMenu>(list);
    }

    public List<SysMenu> getChilds(String s) {
        SysMenuExample example=new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(s);
        return this.sysMenuMapper.selectByExample(example);
    }
}
