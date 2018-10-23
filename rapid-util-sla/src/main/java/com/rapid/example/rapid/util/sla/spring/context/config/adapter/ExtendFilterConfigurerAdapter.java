/**
 *
 */
package com.rapid.example.rapid.util.sla.spring.context.config.adapter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.yueny.superclub.util.sla.internal.application.RateLimiterFilter;

/**
 * Filter扩展
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年5月10日 下午4:47:31
 * @since
 */
@Configuration
public class ExtendFilterConfigurerAdapter {
	/**
	 * @return 编码集过滤器
	 */
	@Bean
	@Order(1)
	public FilterRegistrationBean characterEncodingFilterRegistration() {
		final FilterRegistrationBean registration = new FilterRegistrationBean();

		registration.setFilter(new CharacterEncodingFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("encoding", "UTF-8");
		registration.addInitParameter("forceEncoding", "true");
		registration.setName("encodingFilter");

		return registration;
	}

	// @Bean
	// @Order(2)
	public FilterRegistrationBean rateLimiterFilterRegistration() {
		final FilterRegistrationBean registration = new FilterRegistrationBean();

		final RateLimiterFilter filter = new RateLimiterFilter();
		filter.setLimit(2);
		// filter.setLimiterType(SimpleLimiterType.URL);
		registration.setFilter(filter);
		registration.addUrlPatterns("/*");
		// registration.addInitParameter("a", "b");
		registration.setName("rateLimiterFilter");

		// //是否自动注册 false 取消Filter的自动注册
		// registration.setEnabled(false);

		return registration;
	}

}
