package com.wells.node.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: node
 * @author: wells
 * @create: 2018/12/14
 */
@EnableWebMvc
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {


    /**
     * @param registry 接入拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(localInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/seengene/login")
                .excludePathPatterns("/seengene/logindo");*/

        /**
         * @methods addInterceptor 增加
         * @methods addPathPatterns 接入
         * @methods excludePathPatterns 排除的
         */
        registry.addInterceptor(new LoginInterceptor())
                // .addPathPatterns()
                .excludePathPatterns("/login/**");
    }
}