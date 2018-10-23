/**
 *
 */
package com.yueny.superclub.util.exec.core;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.yueny.superclub.util.exec.BaseTest;
import com.yueny.superclub.util.exec.mock.service.IModifyDemoService;
import com.yueny.superclub.util.exec.mock.service.exec.DemoTaskExecutor;
import com.yueny.superclub.util.exec.multi.MultiThreadSupport;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年10月10日 下午6:31:24
 *
 */
public class MultiThreadSupportTest extends BaseTest {
	@Autowired
	private IModifyDemoService demoService;
	@Autowired
	private DemoTaskExecutor demoTaskExecutor;
	@Autowired
	private MultiThreadSupport multiThreadSupport;

	@Test
	public void testEffect() {
		Assert.assertNotNull(multiThreadSupport);
	}

	@Test
	public void testWithCyclicBarrier() {
		// 获取查询的数据总量
		final List<Long> ids = demoService.queryIds();
		// 进行数据分片， 分为10片
		final Integer splitSize = 10;

		final CyclicBarrier barrier = new CyclicBarrier(splitSize);
		final CountDownLatch latch = new CountDownLatch(splitSize);

		for (int i = 0; i < 10; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						barrier.await();

						multiThreadSupport.processJobs(demoTaskExecutor, Lists.newArrayList("1", "2"));
					} catch (final Exception e) {
					} finally {
						latch.countDown();
					}
				}
			}.start();
		}

		System.out.println("prepare");
		try {
			latch.await();
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("execute");

		try {
			TimeUnit.SECONDS.sleep(12);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("shutdown...");
		// executorService.shutdown();
	}

	@Test
	public void testWithSemaphore() {
		final ExecutorService executorService = Executors.newCachedThreadPool();

		final Semaphore semaphore = new Semaphore(10);
		for (int i = 0; i < 10; i++) {
			final Runnable ru = new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();

						System.out.println("await a monent");
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (final InterruptedException e) {
							e.printStackTrace();
						}

						semaphore.release();
					} catch (final Exception e) {
					}
				}
			};

			executorService.execute(ru);
		}

		System.out.println("prepare");

		System.out.println("execute");

		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("shutdown...");
		executorService.shutdown();
	}

	// @Test
	// public void testReturnExecutorInstance() {
	// final List<Future<Integer>> results =
	// multiThreadSupport.processJobs(demoReturnTaskExecutor,
	// Lists.newArrayList("1", "2"));
	//
	// final List<Future<Integer>> resultsq =
	// multiThreadSupport.processJobs(demoReturnTaskExecutor,
	// Lists.newArrayList("3", "5", "6"));
	//
	// results.addAll(resultsq);
	// for (final Future<Integer> f : results) {
	// try {
	// System.out.println(f.get());
	// } catch (InterruptedException | ExecutionException e) {
	// log.error("线程异常！", e);
	// }
	// }
	//
	// try {
	// TimeUnit.SECONDS.sleep(12);
	// } catch (final InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
}
