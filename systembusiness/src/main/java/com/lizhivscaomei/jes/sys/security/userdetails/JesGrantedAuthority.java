package com.lizhivscaomei.jes.sys.security.userdetails;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by lizhi on 2018/3/30.
 */
public class JesGrantedAuthority implements GrantedAuthority {
    private String authority;
    @Override
    public String getAuthority() {
        return null;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
