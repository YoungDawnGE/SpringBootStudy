package com.gyc.springbootstudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by GYC
 * 2020/11/26 20:27
 *
 * 此类实现接口WebMvcConfigurer接口
 * 并加了@Configuration接口
 * 表示
 * 这个类将拓展SpringMVC的功能
 */
@Configuration
//@EnableWebMvc
public class GycWebMvcConfigurer implements WebMvcConfigurer {

    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    //这个是增加拦截器的
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**");
//    }

    //视图跳转  也可以和Controller  实现一样的功能，但是比Controller方便
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/down").setViewName("download");
        registry.addViewController("/").setViewName("redirect:file/list");
    }
}
