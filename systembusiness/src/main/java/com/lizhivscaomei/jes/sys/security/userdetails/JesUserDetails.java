package com.lizhivscaomei.jes.sys.security.userdetails;

import com.lizhivscaomei.jes.sys.entity.SysDomain;
import com.lizhivscaomei.jes.sys.entity.SysRole;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.entity.SysUserRole;
import com.lizhivscaomei.jes.sys.security.userdetails.entity.JesDomain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by lizhi on 2018/3/30.
 */
public class JesUserDetails extends SysUser implements UserDetails {
    private List<JesGrantedAuthority> authorities;
    public void setAuthorities(List<JesGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
