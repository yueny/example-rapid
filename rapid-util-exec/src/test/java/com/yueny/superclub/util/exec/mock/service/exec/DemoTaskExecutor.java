package com.yueny.superclub.util.exec.mock.service.exec;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yueny.superclub.util.exec.mock.service.IModifyDemoService;
import com.yueny.superclub.util.exec.multi.executor.IExecutor;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年10月10日 下午6:20:55
 *
 */
@Service
public class DemoTaskExecutor implements IExecutor<String> {
	@Autowired
	private IModifyDemoService demoService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.miz.alchemist.common.exec.executor.IExecutor#execute(java.util.List)
	 */
	@Override
	public void execute(final List<String> ts) {
		if (CollectionUtils.isEmpty(ts)) {
			return;
		}

		// final List<ModifyDemoBo> lists = demoService.queryAll();
		// do some service opration
		// 模拟操作耗时:4秒
		System.out.println("await a monent...");
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		for (final String s : ts) {
			System.out.println(s);
		}
	}

}
