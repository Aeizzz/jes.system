package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.common.utils.JavaBeanUtil;
import com.lizhivscaomei.jes.common.view.ViewServiceImpl;
import com.lizhivscaomei.jes.sys.entity.SysParam;
import com.lizhivscaomei.jes.sys.service.SysDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;

/**
 * Created by lizhi on 2018/4/11.
 */
@Service
public class SysParamViewService extends ViewServiceImpl<SysParamVo,SysParam> {
    @Autowired
    SysDomainService sysDomainService;
    @Override
    public SysParamVo dto2vo(SysParam sysParam) {
        SysParamVo vo=new SysParamVo();
        try {
            JavaBeanUtil.javaBean2JavaBean(sysParam,vo);
            vo.setDomainName(sysDomainService.getById(sysParam.getDomainId()).getName());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
