package com.lizhivscaomei.jes.sys.security.userdetails;

import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.VSysUserDomainMenuMapper;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.entity.VSysUserDomainMenu;
import com.lizhivscaomei.jes.sys.entity.VSysUserDomainMenuExample;
import com.lizhivscaomei.jes.sys.service.SysUserService;
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
    @Autowired
    VSysUserDomainMenuMapper vSysUserDomainMenuMapper;
    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        try {
            SysUser user = sysUserService.getByLoginName(loginName);
            if(user!=null){
                JesUserDetails jesUserDetails = new JesUserDetails();
                //基本信息
                jesUserDetails.setId(user.getId());
                jesUserDetails.setLoginName(user.getLoginName());
                jesUserDetails.setName(user.getName());
                jesUserDetails.setPassword(user.getPassword());

                //设置权限
                List<JesGrantedAuthority> authoritieList=new ArrayList<>();
                VSysUserDomainMenuExample example=new VSysUserDomainMenuExample();
                example.setDistinct(true);
                VSysUserDomainMenuExample.Criteria criteria = example.createCriteria();
                criteria.andUserIdEqualTo(jesUserDetails.getId());
                List<VSysUserDomainMenu> menuList = this.vSysUserDomainMenuMapper.selectByExample(example);
                if(menuList!=null&&menuList.size()>0){
                    for(VSysUserDomainMenu menu:menuList){
                        JesGrantedAuthority authoritie=new JesGrantedAuthority();
                        authoritie.setAuthority(menu.getPermission());
                        if(!authoritieList.contains(authoritie)){
                            authoritieList.add(authoritie);
                        }
                    }
                }
                jesUserDetails.setAuthorities(authoritieList);

                return jesUserDetails;
            }else {
                throw new UsernameNotFoundException("用户不存在");
            }
        } catch (AppException e) {
            e.printStackTrace();
        }
        return null;
    }

}
