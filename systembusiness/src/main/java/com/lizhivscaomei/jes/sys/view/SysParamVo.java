package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.sys.entity.SysParam;

/**
 * Created by lizhi on 2018/4/11.
 */
public class SysParamVo extends SysParam {
    private String domainName;

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
