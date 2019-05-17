package com.wells.node.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: node
 * @author: wells
 * @create: 2018/12/14
 */
@EnableWebMvc
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    /**
     * 添加类型转换器和格式化器
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }


    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

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
        registry
                .addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**", "/register/**", "/error/**")
        ;
    }
}