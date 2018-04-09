package com.lizhivscaomei.jes.sys.security.userdetails;

import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhi on 2018/3/30.
 */
@Service
public class JesUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        try {
            SysUser user = sysUserService.getByLoginName(loginName);
            if(user!=null){
                JesUserDetails jesUserDetails=new JesUserDetails();
                jesUserDetails.setLoginName(user.getLoginName());
                jesUserDetails.setName(user.getName());
                jesUserDetails.setPassword(user.getPassword());
                //设置权限
                List<SysMenu> menuList = sysUserService.getMyMenus(user.getId());
                List<JesGrantedAuthority> authorities=new ArrayList<>();
                for(SysMenu sysMenu:menuList){
                    if(StringUtils.isNotEmpty(sysMenu.getPermission())){
                        JesGrantedAuthority authoritie=new JesGrantedAuthority();
                        authoritie.setAuthority(sysMenu.getPermission());
                        authorities.add(authoritie);
                    }
                }
                jesUserDetails.setAuthorities(authorities);
                return jesUserDetails;
            }else {
                throw new UsernameNotFoundException("");
            }
        } catch (AppException e) {
            e.printStackTrace();
        }
        return null;
    }
}
