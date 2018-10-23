/**
 *
 */
package com.yueny.superclub.util.exec.mocktest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yueny.superclub.util.exec.mock.bo.ModifyDemoBo;
import com.yueny.superclub.util.exec.mock.service.IModifyDemoService;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年8月5日 上午11:05:44
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/service/demo-service-test.xml" })
// As of Spring Framework 4.2
@Rollback(value = true) // @Rollback(false). equeals @Commit
@Transactional(value = "transactionManager")
@ActiveProfiles("dev")
public class ModifyDemoServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private IModifyDemoService demoService;

	@Test
	public void testQueryAll() {
		final List<ModifyDemoBo> lists = demoService.queryAll();

		Assert.assertTrue(lists.size() > 1);
	}
}
