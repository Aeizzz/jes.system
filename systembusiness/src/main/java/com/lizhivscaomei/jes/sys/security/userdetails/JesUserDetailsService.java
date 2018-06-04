package com.lizhivscaomei.jes.sys.security.userdetails;

import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.sys.dao.SysDomainMapper;
import com.lizhivscaomei.jes.sys.entity.*;
import com.lizhivscaomei.jes.sys.security.userdetails.entity.JesDomain;
import com.lizhivscaomei.jes.sys.security.userdetails.entity.JesRole;
import com.lizhivscaomei.jes.sys.service.SysDomainService;
import com.lizhivscaomei.jes.sys.service.SysRoleService;
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
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysDomainService sysDomainService;
    @Autowired
    SysDomainMapper sysDomainMapper;
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
                //设置所属域
                this.setDomainList(jesUserDetails);
                //设置权限
                List<JesGrantedAuthority> authoritieList=new ArrayList<>();
                if(jesUserDetails.getDomainList()!=null&&jesUserDetails.getDomainList().size()>0){
                    for(JesDomain domain:jesUserDetails.getDomainList()){
                        if(domain!=null&&domain.getRoleList()!=null){
                            for(JesRole role:domain.getRoleList()){
                                if(role!=null&&role.getJesMenuList()!=null){
                                    for(SysMenu sysMenu:role.getJesMenuList()){
                                        if(StringUtils.isNotEmpty(sysMenu.getPermission())){
                                            JesGrantedAuthority authoritie=new JesGrantedAuthority();
                                            authoritie.setAuthority(sysMenu.getPermission());
                                            authoritieList.add(authoritie);
                                        }
                                    }
                                }
                            }
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
    /*设置所属域列表*/
    private void setDomainList(JesUserDetails jesUserDetails){
        //获取domain列表
        List<JesDomain> domainList=new ArrayList<>();
        for(JesDomain domain:domainList){
            //获取每个domain下的角色
            List<JesRole> roleList=new ArrayList<>();
            for(JesRole role:roleList){
                //获取每个角色下的菜单
                List<SysMenu> menuList=this.sysRoleService.getMenusByRole(role.getId());
                role.setJesMenuList(menuList);
            }
            domain.setRoleList(roleList);
        }
        jesUserDetails.setDomainList(domainList);
        throw new RuntimeException("未完成");
    }
}
