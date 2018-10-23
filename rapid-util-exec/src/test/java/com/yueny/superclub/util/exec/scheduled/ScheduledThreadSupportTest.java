/**
 *
 */
package com.yueny.superclub.util.exec.scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.yueny.superclub.util.exec.BaseTest;
import com.yueny.superclub.util.exec.mock.service.exec.DemoReturnTaskExecutor;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年10月24日 下午3:01:47
 *
 */
public class ScheduledThreadSupportTest extends BaseTest {
	@Autowired
	private DemoReturnTaskExecutor demoReturnTaskExecutor;
	@Autowired
	private ScheduledThreadSupport scheduledThreadSupport;

	@Test
	public void testProcessScheduleJobs() {
		System.out.println("pre: " + new Date());
		scheduledThreadSupport.processScheduleJobs(demoReturnTaskExecutor, Lists.newArrayList("1", "2"), 2,
				TimeUnit.SECONDS);

		try {
			TimeUnit.SECONDS.sleep(12);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
