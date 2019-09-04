package com.yueny.example.rapid.strategy.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 安全拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         //registry.addInterceptor(new WhiteIpCheckInterceptor()).addPathPatterns("/**").excludePathPatterns("/error");
    }

}
