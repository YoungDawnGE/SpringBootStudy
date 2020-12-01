package com.gyc.springbootdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GYC
 * 2020/11/29 23:48
 *
 * 这个xxxConfig东西对应原来的Bean xml配置
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //druid后台监控
    //因为springboot内置了servlet容器，所以没有web.xml,替代方法：注册ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //增加配置
        //1、后台登录的账号密码
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "gyc");//登录的Key是固定的
        map.put("loginPassword", "123");

        //2、允许谁可以访问
        //map.put("allow", "");//如果value为空代表所有人可以访问
        map.put("allow", "");//value=localhost, localhost代表本机能访问

        //3、禁止谁访问 map.put("deny", "192.168.253.128");

        //保存配置:设置初始化参数
        bean.setInitParameters(map);
        return bean;
    }


    //filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求
        Map<String, String> map = new HashMap<>();

        //以下的页面不要用Driud统计
        map.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(map);
        return bean;
    }
}
