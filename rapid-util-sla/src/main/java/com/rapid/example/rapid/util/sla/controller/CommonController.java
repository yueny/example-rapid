package com.rapid.example.rapid.util.sla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@Controller
public class CommonController {
	/**
	 *
	 */
	@RequestMapping(value = "/limit")
	public String error() {
		return "limit";
	}

}
