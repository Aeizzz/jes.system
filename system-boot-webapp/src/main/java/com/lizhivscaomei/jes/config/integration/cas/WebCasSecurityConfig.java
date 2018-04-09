package com.lizhivscaomei.jes.config.integration.cas;


import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


/**
 * CAS集成配置类：
 * @author lizhivscaomei
 */
//@Configuration
//@EnableWebSecurity
public class WebCasSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JesCasUserDetailsService jesCasUserDetailsService;

    @Value("${cas.server.host.url}")
    private String casUrl;
    @Value("${cas.server.host.login_url}")
    private String casLoginUrl;
    @Value("${cas.server.host.logout_url}")
    private String casLogoutUrl;
    @Value("${cas.client.server.host.url}")
    private String appUrl;
    @Value("${cas.client.login.url}")
    private String appLoginUrl;
    @Value("${cas.client.logout.url}")
    private String appLogoutUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.csrf().disable()
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
                .httpBasic();*/
        http.authorizeRequests()//配置安全策略
                .antMatchers("/static/**").permitAll()
                .antMatchers("/jsp/pulic/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                //.antMatchers("/","/hello").permitAll()//定义/请求不需要验证
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
                .logout()
                .permitAll()//定义logout不需要验证
                .and()
                .formLogin();//使用form表单登录
        http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint())
                .and()
                .addFilter(casAuthenticationFilter())
                .addFilterBefore(casLogoutFilter(), LogoutFilter.class)
                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jesUserDetailsService).passwordEncoder(passwordEncoder);
        super.configure(auth);
        auth.authenticationProvider(casAuthenticationProvider());
    }

    /**认证的入口*/
    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
        casAuthenticationEntryPoint.setLoginUrl(casLoginUrl);
        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
        return casAuthenticationEntryPoint;
    }

    /**指定service相关信息*/
    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
//        <!-- Cas Server认证成功后的跳转地址，这里要跳转到我们的Spring Security应用，之后会由CasAuthenticationFilter处理，默认处理地址为 -->
        serviceProperties.setService(appUrl+appLoginUrl);
        serviceProperties.setAuthenticateAllArtifacts(true);
        return serviceProperties;
    }

    /**CAS认证过滤器*/
    /**之后我们需要配置一个CasAuthenticationFilter，
     * 并将其放置在Filter链表中CAS_FILTER的位置，
     * 以处理Cas Server认证成功后的页面跳转，
     * 用以在Spring Security中进行认证。
     * 该Filter会将Cas Server传递过来的ticket（Cas概念）封装成一个Authentication（对应UsernamePasswordAuthenticationToken，
     * 其中ticket作为该Authentication的password），然后传递给AuthenticationManager进行认证。
     * */
    @Bean
    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
        casAuthenticationFilter.setFilterProcessesUrl(appLoginUrl);
        return casAuthenticationFilter;
    }

    /**cas 认证 Provider*/
    @Bean
    public CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        casAuthenticationProvider.setAuthenticationUserDetailsService(jesCasUserDetailsService);
        //casAuthenticationProvider.setUserDetailsService(customUserDetailsService()); //这里只是接口类型，实现的接口不一样，都可以的。
        casAuthenticationProvider.setServiceProperties(serviceProperties());
        casAuthenticationProvider.setTicketValidator(new Cas20ServiceTicketValidator(casUrl));
        casAuthenticationProvider.setKey("casAuthenticationProviderKey");
        return casAuthenticationProvider;
    }

    /**单点注销Filter类，接收cas服务端发出的注销session请求*/
    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setCasServerUrlPrefix(casUrl);
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }

    /**登录退出Filter类，转发至cas服务端进行注销*/
    @Bean
    public LogoutFilter casLogoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter(casLogoutUrl+"service="+appUrl, new SecurityContextLogoutHandler());
        logoutFilter.setFilterProcessesUrl(this.appLogoutUrl);
        return logoutFilter;
    }
}
