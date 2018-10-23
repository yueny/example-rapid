package com.yueny.example.js.marked.controller;

import com.yueny.example.js.marked.service.IModifyDemoService;
import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* 展示控制器
*
* @author yueny09 <deep_blue_yang@163.com>
*
* @DATE 2016年2月16日 下午8:23:11
*
*/
@Controller
public class ShowController extends BaseController {
	@Autowired
	private IModifyDemoService modifyDemoService;

	/**
	 * 展示数据
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getDemoDataPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("title", "JSmarked");

		String demoData = modifyDemoService.getDemoData();

		map.put("data", demoData);
		map.put("secretKey", KEY);

		return "index";
	}

	/**
	 * 编排
	 */
	@RequestMapping(value = "/md2html", method = RequestMethod.GET)
	public String md2htmlPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("title", "在线编辑markdown工具");

		return "md2html";
	}

}
