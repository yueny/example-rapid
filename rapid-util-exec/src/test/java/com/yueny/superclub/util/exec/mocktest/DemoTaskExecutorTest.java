/**
 *
 */
package com.yueny.superclub.util.exec.mocktest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yueny.superclub.util.exec.BaseTest;
import com.yueny.superclub.util.exec.mock.service.exec.DemoTaskExecutor;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年10月10日 下午6:27:51
 *
 */
public class DemoTaskExecutorTest extends BaseTest {
	@Autowired
	private DemoTaskExecutor demoTaskExecutor;

	@Test
	public void testInstance() {
		System.out.println(demoTaskExecutor);
	}
}
