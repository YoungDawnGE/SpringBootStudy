package com.gyc.springbootsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by GYC
 * 2020/12/1 20:35
 * Spring Security的配置
 *
 * 源代码无需改动
 * 采用了AOP的方式实现了拦截器的功能。
 */


@EnableWebSecurity  //这个@EnableWebSecurity是关闭SpringSecurity原有的配置
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页有权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1").hasRole("vip1")
                .antMatchers("/level2").hasRole("vip2")
                .antMatchers("/level3").hasRole("vip3");

        //没有权限跳到登录页面
        http.formLogin();

        //开启注销功能
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1、内存中的认证
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("gyc").password(new BCryptPasswordEncoder().encode("123")).roles("vip2", "vip3")
                .and()
                .withUser("hr").password(new BCryptPasswordEncoder().encode("123")).roles("vip1");

        //要对密码加密，否贼会报错There is no PasswordEncoder mapped for the id "null"
        //在Spring5.0中新增了很多加密方式

        //2、jdbc中的认证，正常应该走数据库
        //auth.jdbcAuthentication();
    }

}
