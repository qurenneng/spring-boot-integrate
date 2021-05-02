package com.example.springbootsecurityintegrat.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author qrn
 * @Date 2021/5/2 下午12:41
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 * EnableWebSecurity 开启权限认证服务：
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义权限的访问服务：
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则：/ 都允许访问，不需要授权，/level1/** 接口都需要 角色是 VIP1才能进行访问
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/level1/**").hasRole("VIP1");

        //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");

        http.logout().logoutSuccessUrl("/");

        //记住我功能
        //http.rememberMe()
        http.rememberMe().rememberMeParameter("remeber");
    }

    //定义认证授权规则，由于是演示，我这里就从内存中读取了 inMemoryAuthentication 这个可以改成jdbc读取。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root")
                .password("root").roles("VIP1","VIP2").and().withUser("xiaoming")
                .password("123456").roles("VIP3");
    }

}
