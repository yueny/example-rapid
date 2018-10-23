package com.rapid.example.topic.profiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rapid.example.topic.profiler.manager.IUserLoginManager;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
public class DemoController {
	@Autowired
	private IUserLoginManager userLoginManager;

	/**
	 *
	 */
	@ApiOperation(value = "一个测试API", notes = "第一个测试API")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "query", value = "query类型参数", required = true, paramType = "query", dataType = "String") })
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String bar(final String query) {
		userLoginManager.login("hello");

		// WebApplicationContextUtils.

		return "welcome";
	}

}
