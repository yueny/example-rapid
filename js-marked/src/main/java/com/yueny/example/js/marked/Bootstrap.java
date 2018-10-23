package com.yueny.example.js.marked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年5月14日 下午4:46:43
 */
@SpringBootApplication
@ImportResource(locations = { "classpath:/config/cfg-properties.xml"})
public class Bootstrap {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

	public static void main(final String[] args) {
		try {
			SpringApplication.run(Bootstrap.class, args);
		} catch (final Exception e) {
			logger.error("服务启动异常:", e);
			e.printStackTrace();
		}
	}

}