package com.question.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 *拦截器
 *@author Ye
 *@create 2020/5/31 21:19
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
//                .excludePathPatterns("/", "/css/**", "/js/**", "/fonts/**", "**.gif");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/welcome.html").setViewName("welcome");
        registry.addViewController("/welcome1.html").setViewName("welcome1");
        registry.addViewController("/unicode.html").setViewName("unicode");
        registry.addViewController("/cate.html").setViewName("cate");
        registry.addViewController("/role-add.html").setViewName("role-add");
        registry.addViewController("/order-list.html").setViewName("order-list");
        registry.addViewController("/order-list1.html").setViewName("order-list1");
        registry.addViewController("/order-add.html.html").setViewName("order-add");
        registry.addViewController("/member-password.html").setViewName("member-password");
        registry.addViewController("/member-list.html").setViewName("member-list");
        registry.addViewController("/member-list1.html").setViewName("member-list1");
        registry.addViewController("/member-del.html").setViewName("member-del");
        registry.addViewController("/member-edit.html").setViewName("member-edit");
        registry.addViewController("/log.html").setViewName("log");
        registry.addViewController("/error.html").setViewName("error");
        registry.addViewController("/echarts1.html").setViewName("echarts1");
        registry.addViewController("/echarts2.html").setViewName("echarts2");
        registry.addViewController("/echarts3.html").setViewName("echarts3");
        registry.addViewController("/echarts4.html").setViewName("echarts4");
        registry.addViewController("/echarts5.html").setViewName("echarts5");
        registry.addViewController("/echarts6.html").setViewName("echarts6");
        registry.addViewController("/echarts7.html").setViewName("echarts7");
        registry.addViewController("/echarts8.html").setViewName("echarts8");
        registry.addViewController("/demo.html").setViewName("demo");
        registry.addViewController("/city.html").setViewName("city");
        registry.addViewController("/admin-rule.html").setViewName("admin-rule");
        registry.addViewController("/admin-role.html").setViewName("admin-role");
        registry.addViewController("/admin-list.html").setViewName("admin-list");
        registry.addViewController("/admin-edit.html").setViewName("admin-edit");
        registry.addViewController("/admin-cate.html").setViewName("admin-cate");
        registry.addViewController("/admin-add.html").setViewName("admin-add");

    }

}
