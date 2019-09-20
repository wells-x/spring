package com.wells.account;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.wells.account.interceptor", "com.wells.account.filter",})
public class AccountApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AccountApplication.class);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(args));

        SpringApplication.run(AccountApplication.class, args);
    }
}