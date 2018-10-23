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

import com.yueny.superclub.util.exec.mock.dao.IModifyDemoMapper;
import com.yueny.superclub.util.exec.mock.entry.ModifyDemoEntry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/dao/demo-dao-test.xml" })
// As of Spring Framework 4.2
@Rollback(value = true) // @Rollback(false). equeals @Commit
@Transactional(value = "transactionManager")
@ActiveProfiles("dev")
public class IModifyDemoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private IModifyDemoMapper modifyDemoMapper;

	@Test
	public void testSelectAll() {
		System.out.println(modifyDemoMapper);

		final List<ModifyDemoEntry> list = modifyDemoMapper.selectAll();
		Assert.assertTrue(list.size() > 0);
	}
}
