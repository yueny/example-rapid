package com.yueny.superclub.util.exec.mock.service.exec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.yueny.superclub.util.exec.multi.executor.IReturnExecutor;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年10月10日 下午6:20:55
 *
 */
@Service
public class DemoReturnTaskExecutor implements IReturnExecutor<String, Integer> {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.miz.alchemist.common.exec.executor.IExecutor#execute(java.util.List)
	 */
	@Override
	public Integer execute(final List<String> ts) {
		if (CollectionUtils.isEmpty(ts)) {
			return -1;
		}

		// do some service opration
		System.out.println("await a monent...");

		// 模拟操作耗时:4秒
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		for (final String s : ts) {
			System.out.println("ts is : " + s);
		}
		return ts.size();
	}

}
