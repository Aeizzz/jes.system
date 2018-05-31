package com.lizhivscaomei.jes.config.security.cas;

import com.lizhivscaomei.jes.sys.security.userdetails.JesUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class JesCasUserDetailsService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {
    @Autowired
    JesUserDetailsService jesUserDetailsService;
    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        System.out.println("CAS当前的用户名是："+token.getName());
        return jesUserDetailsService.loadUserByUsername(token.getName());
    }
}
