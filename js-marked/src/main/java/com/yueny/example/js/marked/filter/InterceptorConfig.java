package com.yueny.example.js.marked.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 安全拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	// log context
	private ServiceContextInterceptor sci;

	/**
	 * 系统上下文，一次性加载
	 */
	@Value("${app.ctx}")
	private String ctx;
	
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		if(sci == null){
			sci = new ServiceContextInterceptor();
			sci.setCtx(ctx);
		}

		registry.addInterceptor(sci).addPathPatterns("/**");
	}

}
