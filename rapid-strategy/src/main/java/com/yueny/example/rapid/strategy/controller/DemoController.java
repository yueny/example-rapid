package com.yueny.example.rapid.strategy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String bar() {
		return "welcome";
	}

}
