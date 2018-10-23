package com.yueny.example.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yueny.example.portal.service.DemoService;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年2月20日 上午11:05:53
 *
 */
@Controller
public class DemoController {
	@Autowired
	private DemoService demoService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/demo/userLog")
	@ResponseBody
	public String index(final Model model) {
		logger.info("控制层方法调用");
		final Integer rs = demoService.userLog();
		model.addAttribute("demo", rs);

		logger.info("控制层方法执行结果：{}。", rs);
		return null;
	}

	@RequestMapping("/demo/userService")
	@ResponseBody
	public String queryByUserId(final Model model) {
		final boolean rs = demoService.queryByUserId(66L);
		model.addAttribute("data", rs);

		return null;
	}

}
