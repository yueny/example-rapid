package com.yueny.example.log.web;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.yueny.example.log.service.IUserLogTraceService;
import com.yueny.rapid.data.resp.pojo.response.NormalResponse;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月19日 下午3:19:30
 *
 */
@Service
public class UserLogTraceService implements IUserLogTraceService {
	// AtomicInteger通过一种线程安全的加减操作接口
	private final AtomicInteger atomic = new AtomicInteger();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public NormalResponse<Integer> execute() {
		final NormalResponse<Integer> resp = new NormalResponse<>();

		final int rs = atomic.getAndIncrement();
		logger.info("日志跟踪execute服务执行， 结果:{}.", rs);

		resp.setData(rs);
		return resp;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.yueny.example.log.service.IUserLogTraceService#ugs()
	 */
	@Override
	public NormalResponse<Integer> ugs() {
		final NormalResponse<Integer> resp = new NormalResponse<>();

		final int rs = atomic.getAndIncrement();
		logger.info("日志跟踪ugs服务执行， 结果:{}.", rs);

		resp.setData(rs);
		return resp;
	}

}
