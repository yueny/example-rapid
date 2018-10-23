package com.yueny.superclub.util.exec.exectest.count;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.yueny.superclub.util.exec.exectest.count.callble.SimpleNumberVolatileRunnable;

/**
 * @author yueny(yueny09@163.com)
 * @date 2015年7月23日 下午11:04:52
 *
 */
public class SimpleNumberVolatileCountLimitTest {
	private final ExecutorService threadPoolExecutor = Executors
			.newFixedThreadPool(50000);

	/**
	 *
	 */
	@Test
	public void testSimpleNumberVolatile() {
		final SimpleNumberVolatileRunnable simpleNumberVolatileRunnable = new SimpleNumberVolatileRunnable();

		final int count = 50000;
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
		simpleNumberVolatileRunnable.setCyclicBarrier(cyclicBarrier);

		// 并发数目
		for (int i = 0; i < count; i++) {
			threadPoolExecutor.execute(simpleNumberVolatileRunnable);
		}

		threadPoolExecutor.shutdown();
		while (!threadPoolExecutor.isTerminated()) {
			try {
				Thread.sleep(10);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("MoreMaps:"
				+ simpleNumberVolatileRunnable.getMoreMaps());
	}

}
