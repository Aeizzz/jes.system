package com.lizhivscaomei.jes.sys.security.userdetails.entity;

import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysRole;

import java.util.List;

/**
 * Created by lizhi on 2018/6/4.
 */
public class JesRole extends SysRole {
    private List<SysMenu> jesMenuList;

    public List<SysMenu> getJesMenuList() {
        return jesMenuList;
    }

    public void setJesMenuList(List<SysMenu> jesMenuList) {
        this.jesMenuList = jesMenuList;
    }
}
