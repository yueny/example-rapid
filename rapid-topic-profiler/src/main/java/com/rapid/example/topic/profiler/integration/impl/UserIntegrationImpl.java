/**
 *
 */
package com.rapid.example.topic.profiler.integration.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.rapid.example.topic.profiler.integration.IUserIntegration;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月3日 下午6:24:42
 *
 *       <pre>
 *       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(new =
 *       UserIntegrationImpl());
 *       or
 *       extends SpringBeanAutowiringSupport
 *       </pre>
 */
@Service
public class UserIntegrationImpl implements IUserIntegration {
	/*
	 * (non-Javadoc)
	 *
	 * @see com.rapid.example.topic.profiler.integration.IUserIntegration#
	 * queryDistByCode(java.lang.String)
	 */
	@Override
	public Long queryDistByCode(final String code) {
		try {
			TimeUnit.MILLISECONDS.sleep(800L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		return 88L;
	}

}
