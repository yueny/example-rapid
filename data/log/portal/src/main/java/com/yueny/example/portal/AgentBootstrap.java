package com.yueny.example.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource(locations = { "classpath:/config/dubbo/dubbo-consumer.xml", 
		"classpath:/config/spring-zipkin.xml",
		"classpath:/config/cfg-properties.xml"})
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.yueny.example.portal" })
public class AgentBootstrap extends SpringBootServletInitializer {
	/**
	 * jar启动
	 */
	public static void main(final String[] args) {
		SpringApplication.run(AgentBootstrap.class, args);
	}

	/*
	 * tomcat war启动
	 *
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#
	 * configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(AgentBootstrap.class);
	}
}
