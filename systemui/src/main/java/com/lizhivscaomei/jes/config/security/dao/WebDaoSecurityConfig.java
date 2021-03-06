package com.lizhivscaomei.jes.config.security.dao;


import com.lizhivscaomei.jes.sys.security.userdetails.JesUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Spring Security配置类
 * @author lizhivscaomei
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebDaoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JesUserDetailsService jesUserDetailsService;

    /*http协议安全配置*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭CSRF攻击
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/jsp/pulic/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .anyRequest().authenticated()//其余的所有请求都需要验证
                //登录相关
                .and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home")
                .and().sessionManagement().maximumSessions(1).sessionRegistry(new SessionRegistryImpl())
                .and()
                //登出相关
                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
                .and()
                //header相关
                .headers().frameOptions().disable()
                .and().httpBasic();

    }

    //配置认证管理器，需要的UserDetailsService和密码编码器
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jesUserDetailsService).passwordEncoder(passwordEncoder);
    }

}
