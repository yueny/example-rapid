/**
 *
 */
package com.yueny.example.log.job;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yueny.superclub.util.exec.async.factory.NamedThreadFactory;

/**
 * 数据初始化加载
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月22日 下午6:21:02
 * @since
 */
@Service
public class DataInitService {
	// implements InitializingBean, DisposableBean {
	/**
	 * Logger available to subclasses.
	 */
	protected final Logger logger = LoggerFactory.getLogger(DataInitService.class);
	/* 起一个定时线程，去轮询常量信息放入 ServiceContextInitDataHolder */
	// 定时任务执行器
	private final ScheduledExecutorService retryExecutor = Executors.newScheduledThreadPool(1,
			new NamedThreadFactory(getClass().getName() + "QueryTimer", true));

	// 失败重试定时器，定时检查是否有请求失败，如有，无限次重试
	private ScheduledFuture<?> retryFuture;

	@PostConstruct
	public final void afterPropertiesSet() {
		logger.info("I'm  init  method  using  @PostConstrut....");

		// 延迟5秒进行
		this.retryFuture = retryExecutor.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 加载
				try {
					logger.info("reload...");
				} catch (final Throwable t) { // 防御性容错
					logger.error("Unexpected error occur at failed retry, cause: " + t.getMessage(), t);
				}
			}
		}, 1L,
				// 默认延迟轮询时间
				3L, TimeUnit.SECONDS);
	}

	@PreDestroy
	public final void destroy() {
		logger.info("I'm  destory method  using  @PreDestroy.....");

		try {
			retryFuture.cancel(true);
		} catch (final Throwable t) {
			logger.warn(t.getMessage(), t);
		}
	}

}
