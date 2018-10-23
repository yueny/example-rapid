package com.yueny.superclub.util.exec.exectest.count.callble;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.yueny.superclub.util.exec.exectest.BaseTestRunnable;

/**
 * 在并发的情况下保证数据的原子性：volatile关键字
 *
 * @author yueny(yueny09@163.com)
 * @date 2015年7月24日 上午9:17:53
 *
 */
public class SimpleNumberVolatileRunnable extends BaseTestRunnable {
	private static Map<Integer, Integer> maps = new ConcurrentHashMap<Integer, Integer>();
	private volatile int count = 0;
	// private static final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock lock = new ReentrantLock();

	/**
	 * @return 统计多次出现的数字
	 */
	public Map<Integer, Integer> getMoreMaps() {
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (final Map.Entry<Integer, Integer> entry : maps.entrySet()) {
			if (entry.getValue() > 1) {
				map.put(entry.getKey(), entry.getValue());
			}
		}
		return map;
	}

	@Override
	protected void runExec() {
		try {
			lock.lock();

			count++;
			if (maps.get(count) == null) {
				maps.put(count, 1);
			} else {
				maps.put(count, maps.get(count) + 1);
			}

			System.out.println(count);
		} catch (final Exception e) {
			// .
		} finally {
			lock.unlock();
		}

	}

}
