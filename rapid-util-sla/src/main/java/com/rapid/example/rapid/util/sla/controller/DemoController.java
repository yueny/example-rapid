package com.rapid.example.rapid.util.sla.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import com.yueny.superclub.util.sla.api.SlaRateLimit;
import com.yueny.superclub.util.sla.enums.SlaRateLimitReturnType;
import com.yueny.superclub.util.sla.enums.SlaRateLimitType;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
public class DemoController {
	/**
	 *
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@SlaRateLimit(type = SlaRateLimitType.WEB, threshold = 2, returnType = SlaRateLimitReturnType.JSON)
	public NormalResponse<String> welcome(final String mobile) {
		final NormalResponse<String> resp = new NormalResponse<String>();

		try {
			TimeUnit.MILLISECONDS.sleep(5000L);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		resp.setData(mobile);

		return resp;
	}

}
