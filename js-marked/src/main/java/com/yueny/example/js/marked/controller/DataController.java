package com.yueny.example.js.marked.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yueny.example.js.marked.bo.ModifyDemoBo;
import com.yueny.example.js.marked.service.IModifyDemoService;
import com.yueny.rapid.data.resp.pojo.response.JsonListResponse;
import com.yueny.rapid.data.resp.pojo.response.NormalResponse;
import com.yueny.superclub.util.crypt.core.AESCoder;
import com.yueny.superclub.util.crypt.core.Base64Coder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public JsonListResponse<ModifyDemoBo> getData(HttpServletRequest request, HttpServletResponse response) {
		logger.info("展示控制查询");

		JsonListResponse<ModifyDemoBo> resp = new JsonListResponse<>();

		List<ModifyDemoBo> userList = modifyDemoService.queryAll();
		resp.setData(userList);

		logger.info("慢服务列表查询结果：{}。", resp);
		return resp;
	}

	/**
	 * 展示数据
	 */
	@RequestMapping(value = "/demo/data", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public NormalResponse<String> getDemoData(String cryptoType, String encodeStr, HttpServletRequest request, HttpServletResponse response) {
		NormalResponse<String> resp = new NormalResponse<>();

		String val = "";
		if(StringUtils.equalsIgnoreCase(cryptoType, "Base64")){
			val = Base64Coder.decryptVal(encodeStr);
		}else if(StringUtils.equalsIgnoreCase(cryptoType, "aes")){
			val = AESCoder.decrypt(encodeStr, KEY);
		}
		logger.info("密文:{}, 明文：{}。", encodeStr, val);

		String demoData = modifyDemoService.getDemoData();
		resp.setData(demoData);

		return resp;
	}

}
