package com.yueny.superclub.util.exec.exectest.count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.yueny.superclub.util.exec.exectest.count.callble.MethodCountLimitRunnableTest;

/**
 * @author yueny(yueny09@163.com)
 * @date 2015年7月23日 下午11:04:52
 *
 */
public class MethodCountTest {
	private final ExecutorService threadPoolExecutor = Executors
			.newFixedThreadPool(2);

	/**
	 *
	 */
	@Test
	public void test() {
		for (int i = 0; i < 3001; i++) {
			threadPoolExecutor.execute(new MethodCountLimitRunnableTest());
		}

		try {
			Thread.sleep(5000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

	}

}
