/**
 *
 */
package com.rapid.example.rapid.util.sla.spring.context.config.adapter;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import com.yueny.rapid.lang.json.CustomAllEncompassingFormHttpMessageConverter;
import com.yueny.rapid.lang.json.CustomMappingJackson2HttpMessageConverter;

/**
 * 拦截器扩展
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年5月10日 下午4:47:31
 * @since
 */
@Configuration
public class ExtendInterceptorConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// final RateLimiterInterceptor rateLimiterInterceptor = new
		// RateLimiterInterceptor();
		// rateLimiterInterceptor.setLimit(2);
		// registry.addInterceptor(rateLimiterInterceptor).addPathPatterns("/**");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #configureMessageConverters(java.util.List)
	 */
	@Override
	public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new ResourceHttpMessageConverter());
		converters.add(new CustomAllEncompassingFormHttpMessageConverter("UTF-8"));

		final StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
				Charset.forName("UTF-8"));
		stringHttpMessageConverter.setWriteAcceptCharset(false);
		stringHttpMessageConverter
				.setSupportedMediaTypes(Lists.newArrayList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML));
		converters.add(stringHttpMessageConverter);

		converters.add(new CustomMappingJackson2HttpMessageConverter("UTF-8"));

		// json转换器.避免IE执行AJAX时,返回JSON出现下载文件
		final FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		fastJsonHttpMessageConverter
				.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		converters.add(fastJsonHttpMessageConverter);
	}

}
