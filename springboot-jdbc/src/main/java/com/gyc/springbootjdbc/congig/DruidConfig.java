package com.gyc.springbootjdbc.congig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

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
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "druid/*");
        //增加配置  后台登录的账号密码
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "gyc");//登录的Key是固定的
        map.put("loginPassword", "123");

        //允许谁可以访问
//        map.put("allow", "");//如果value为空代表所有人可以访问
        map.put("allow", "localhost");//localhost代表本机能访问

        //禁止谁访问 map.put("deny", "192.168.253.128");

        bean.setInitParameters(map);

        return bean;
    }
}
