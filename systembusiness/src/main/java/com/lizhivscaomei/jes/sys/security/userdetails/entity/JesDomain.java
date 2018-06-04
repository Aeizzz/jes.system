package com.lizhivscaomei.jes.sys.security.userdetails.entity;

import com.lizhivscaomei.jes.sys.entity.SysDomain;

import java.util.List;

/**
 * Created by lizhi on 2018/6/4.
 */
public class JesDomain extends SysDomain {
    private List<JesRole> roleList;

    public List<JesRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<JesRole> roleList) {
        this.roleList = roleList;
    }
}
