package com.yueny.example.portal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yueny.example.log.service.IUserLogTraceService;
import com.yueny.example.log.service.IUserService;
import com.yueny.rapid.data.resp.pojo.response.NormalResponse;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年2月20日 上午11:04:49
 *
 */
@Service
public class DemoService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserLogTraceService userLogTraceService;
	/*
	 * 调用Dubbo暴露的接口
	 */
	@Autowired
	private IUserService userService;

	public boolean queryByUserId(final Long userId) {
		final NormalResponse<Boolean> resp = userService.queryByUserId(userId);
		return resp.getData();
	}

	public Integer userLog() {
		logger.info("服务层方法执行之前...");
		NormalResponse<Integer> resp = userLogTraceService.execute();
		logger.info("服务层方法执行， execute结果：{}/{}.", resp.getCode(), resp);

		resp = userLogTraceService.ugs();
		logger.info("服务层方法执行， ugs结果：{}/{}.", resp.getCode(), resp);
		return resp.getData();
	}

}
