package com.miz.example.rapid.safety.box.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.miz.rapid.safety.box.web.request.WhiteIpCheckInterceptor;

/**
 * 安全拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new WhiteIpCheckInterceptor()).addPathPatterns("/**").excludePathPatterns("/error");
    }

}
