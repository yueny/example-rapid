package com.yueny.example.rapid.strategy.controller;

import com.yueny.example.rapid.strategy.container.IRespContainer;
import com.yueny.example.rapid.strategy.service.IRespStrategy;
import com.yueny.example.rapid.strategy.service.RespType;
import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
public class DemoController {
	@Autowired
	private IRespContainer container;

	/**
	 *
	 */
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	@ResponseBody
	public NormalResponse<RespType> bar(String type) {
		RespType respType = RespType.getType(type);

		IRespStrategy strategy = container.getStrategy(respType);
		if(strategy != null){
			NormalResponse<RespType> response = strategy.builder();
			return response;
		}

		return new NormalResponse<>();
	}

}
