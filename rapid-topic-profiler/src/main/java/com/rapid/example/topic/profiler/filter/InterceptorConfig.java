package com.rapid.example.topic.profiler.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yueny.rapid.adapter.digest.web.interceptor.DigestLogHandlerInterceptor;

/**
 * 安全拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	/**
	 *
	 */
	@Value("${digest.log.name}")
	private String digestLogName;

	/**
	 * 是否输出摘要统计， 默认不输出摘要统计false
	 */
	@Value("${digest.print.pigeonhole}")
	private boolean printDigstPigeonhole;

	/**
	 * 默认为超过xxx ms即为慢操作
	 */
	@Value("${digest.slow.dump.threshold}")
	private Long slowDumpThreshold;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// final WebDigestLogHandlerInterceptor digestLogHandlerInterceptor =
		// new WebDigestLogHandlerInterceptor(
		// digestLogName);
		// digestLogHandlerInterceptor.setPrintDigstPigeonhole(printDigstPigeonhole);
		// digestLogHandlerInterceptor.setSlowDumpThreshold(slowDumpThreshold);
		//
		// registry.addInterceptor(digestLogHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/error");

		final DigestLogHandlerInterceptor digestLogHandlerInterceptor = new DigestLogHandlerInterceptor(digestLogName);
		digestLogHandlerInterceptor.setPrintDigstPigeonhole(printDigstPigeonhole);
		digestLogHandlerInterceptor.setSlowDumpThreshold(slowDumpThreshold);

		registry.addInterceptor(digestLogHandlerInterceptor).addPathPatterns("/").addPathPatterns("/**")
				.excludePathPatterns("/error");
	}

}
