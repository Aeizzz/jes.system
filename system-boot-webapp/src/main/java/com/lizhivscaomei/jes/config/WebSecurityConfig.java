package com.lizhivscaomei.jes.config;


import com.lizhivscaomei.jes.sys.JesUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 配置类：
 * 配置security的登录页面和传递的参数，公共路径权限属性等
 *
 * @author CHENY037
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JesUserDetailsService jesUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/jsp/pulic/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .anyRequest().authenticated()
                //登录相关
                .and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home")
                .and().sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry)
                .and().and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jesUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SessionRegistry getSessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
}
