package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.sys.entity.SysMenu;

/**
 * Created by lizhi on 2018/4/11.
 */
public class SysMenuVo extends SysMenu {
    private String domainName;

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
