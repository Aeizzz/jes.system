package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.common.utils.JavaBeanUtil;
import com.lizhivscaomei.jes.common.view.ViewServiceImpl;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.service.SysDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;

/**
 * Created by lizhi on 2018/4/11.
 */
@Service
public class SysMenuViewService extends ViewServiceImpl<SysMenuVo,SysMenu> {
    @Autowired
    SysDomainService sysDomainService;
    @Override
    public SysMenuVo dto2vo(SysMenu sysMenu) {
        SysMenuVo vo=new SysMenuVo();
        try {
            JavaBeanUtil.javaBean2JavaBean(sysMenu,vo);
            vo.setDomainName(sysDomainService.getById(sysMenu.getDomainId()).getName());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
