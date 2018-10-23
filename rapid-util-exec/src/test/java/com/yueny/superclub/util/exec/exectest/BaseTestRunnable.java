package com.yueny.superclub.util.exec.exectest;

import java.util.concurrent.CyclicBarrier;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yueny(yueny09@163.com)
 * @date 2015年7月24日 下午1:19:11
 *
 */
public abstract class BaseTestRunnable implements Runnable {
	@Getter
	@Setter
	private CyclicBarrier cyclicBarrier;

	@Override
	public void run() {
		try {
			// 等待所有任务准备就绪
			cyclicBarrier.await();

			runExec();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract void runExec();

}
