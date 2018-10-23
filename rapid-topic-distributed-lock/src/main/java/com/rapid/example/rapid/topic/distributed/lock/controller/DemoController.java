package com.rapid.example.rapid.topic.distributed.lock.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import com.yueny.rapid.topic.distributed.lock.DistributedLock;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
public class DemoController {
	@Autowired
	private DistributedLock distriLock;

	/**
	 *
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public NormalResponse<String> welcome(final String mobile) {
		final NormalResponse<String> resp = new NormalResponse<String>();
		System.out.println(Thread.currentThread().getId());

		if (distriLock.tryLock(mobile)) {
			try {
				TimeUnit.MILLISECONDS.sleep(5000L);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			} finally {
				distriLock.unlock(mobile);
			}

			resp.setData(mobile);
		} else {
			System.out.println("fail");
			resp.setData("操作拒绝");
		}

		return resp;
	}

}
