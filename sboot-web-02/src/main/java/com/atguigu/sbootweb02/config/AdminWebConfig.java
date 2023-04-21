package com.atguigu.sbootweb02.config;

import com.atguigu.sbootweb02.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 1、编辑一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 * @EnableWebMvc:全面接管
 *      1、静态资源？视图解析器？欢迎页……全部失效
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

//    /**
//     * 定义静态资源行为
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/aa/**").addResourceLocations("classpath:/static/");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                //所有资源包括静态资源也被拦截了
                        addPathPatterns("/**").
                //放行的请求
                        excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");
    }

//    @Bean
//    public WebMvcRegistrations webMvcRegistrations() {
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return WebMvcRegistrations.super.getRequestMappingHandlerMapping();
//            }
//        };
//    }
}
