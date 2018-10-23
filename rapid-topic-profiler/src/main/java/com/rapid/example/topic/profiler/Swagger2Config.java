package com.rapid.example.topic.profiler;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
// 必须存在
@EnableWebMvc
// 必须存在扫描的APIController package name，也可以直接扫描class
// @ComponentScan(basePackages = { "com.rapid.example.topic.profiler.controller"
// })
public class Swagger2Config {
	@Value("${dev.mode}")
	private boolean devMode;

	@Resource
	private DocumentationPluginsBootstrapper swagger2;

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("米庄理财Swagger2").description("米庄理财Swagger2")
				.termsOfServiceUrl("https://www.mizlicai.com/").version("1.0").build();
	}

	@Bean
	public Docket createRestApi() {
		// 非开发模式下不启动Swagger2
		if (!devMode) {
			try {
				final Field field = DocumentationPluginsBootstrapper.class.getDeclaredField("initialized");
				field.setAccessible(true);
				field.set(swagger2, new AtomicBoolean(true));
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.rapid.example.topic.profiler.controller"))
				.paths(PathSelectors.any()).build();
	}

}
