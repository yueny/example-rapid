/**
 *
 */
package com.yueny.example.rapid.strategy.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年10月27日 下午7:00:21
 *
 */
@Slf4j
@Component
public class CheckJockForEmailJob {
	/**
	 * 默认的执行方式是串行执行
	 *
	 * @Scheduled 注解用于标注这个方法是一个定时任务的方法，有多种配置可选。<br>
	 *            cron支持cron表达式，指定任务在特定时间执行；<br>
	 *            fixedRate以特定频率执行任务， 单位 毫秒milliseconds；<br>
	 *            fixedRateString以string的形式配置执行频率。
	 */
	@Scheduled(cron = "0/30 * * * * ?")
	public void doSomething() {
		send("yuanyang", "deep_vlue_yang@163.com");
	}

	private boolean send(final String userName, final String to) {


		return true;
	}

}
