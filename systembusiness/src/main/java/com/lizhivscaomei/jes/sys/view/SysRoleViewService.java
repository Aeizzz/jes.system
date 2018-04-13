package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.common.utils.JavaBeanUtil;
import com.lizhivscaomei.jes.common.view.ViewServiceImpl;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.service.SysDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;

/**
 * Created by lizhi on 2018/4/11.
 */
@Service
public class SysRoleViewService extends ViewServiceImpl<SysRoleVo,SysRole> {
    @Autowired
    SysDomainService sysDomainService;
    @Override
    public SysRoleVo dto2vo(SysRole sysRole) {
        SysRoleVo vo=new SysRoleVo();
        try {
            JavaBeanUtil.javaBean2JavaBean(sysRole,vo);
            vo.setDomainName(sysDomainService.getById(sysRole.getDomainId()).getName());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
