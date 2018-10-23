package com.yueny.superclub.util.exec.exectest.count.callble;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 某个方法限制每秒访问次数
 *
 * @author yueny(yueny09@163.com)
 * @date 2015年7月23日 下午10:54:05
 *
 */
public class MethodVolatileRunnable implements Runnable {
	private static volatile Map<String, Integer> maps = new ConcurrentHashMap<String, Integer>();

	/**
	 * ReadWriteLock
	 */
	public void myMethodByReadWriteLock() {
		try {
			// 取当前秒，每秒限制访问次数
			final String times = getCurrentSeconds();
			if (maps.get(times) == null) {
				maps.put(times, 1);
			} else {
				maps.put(times, maps.get(times) + 1);
				if (maps.get(times) > 30) {
					System.out.println("每秒内只能调用30次哦，当前秒：" + times);
					return;
				}
			}
			System.out.println("测试方法，第" + maps.get(times) + "次！");
		} catch (final Exception e) {
			// .
		}
	}

	@Override
	public void run() {
		testEsxec();
	}

	/**   */
	public void testEsxec() {
		final Long start = System.currentTimeMillis();
		for (int i = 0; i < 35; i++) {
			myMethodByReadWriteLock();
		}
		final Long end = System.currentTimeMillis();
		System.out.println("历时：" + (end - start) + "毫秒");
	}

	private String getCurrentSeconds() {
		final Calendar c = Calendar.getInstance();
		c.setTime(new java.util.Date());
		// final int year = c.get(Calendar.YEAR); //取年份
		// final int month = c.get(Calendar.MONTH) + 1; //取月份
		// final int day = c.get(Calendar.DAY_OF_MONTH); //取日
		// final int hour = c.get(Calendar.HOUR_OF_DAY); //取小时
		// final int minute = c.get(Calendar.MINUTE); //取分钟
		// final int second = c.get(Calendar.SECOND); // 取秒

		final DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		// eg. 20150722162755
		return df.format(new java.util.Date());
	}

}
