package com.yueny.example.proxy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yueny.example.proxy.bo.ModifyDemoBo;
import com.yueny.example.proxy.service.IModifyDemoService;
import com.yueny.rapid.data.resp.pojo.response.JsonListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* 展示控制器
*
* @author yueny09 <deep_blue_yang@163.com>
*
* @DATE 2016年2月16日 下午8:23:11
*
*/
@RestController
public class DataController extends BaseController {
	@Autowired
	private IModifyDemoService modifyDemoService;

	/**
	 * 展示数据
	 */
	@RequestMapping(value = "/get/list", method = RequestMethod.GET)
	public JsonListResponse<ModifyDemoBo> getData(HttpServletRequest request, HttpServletResponse response) {
		logger.info("展示控制查询");

		JsonListResponse<ModifyDemoBo> resp = new JsonListResponse<>();

		List<ModifyDemoBo> userList = modifyDemoService.queryAll();
		resp.setData(userList);

		logger.info("慢服务列表查询结果：{}。", resp);
		return resp;
	}

}
