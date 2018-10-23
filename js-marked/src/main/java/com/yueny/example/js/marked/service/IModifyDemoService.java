package com.yueny.example.js.marked.service;

import com.yueny.example.js.marked.bo.ModifyDemoBo;

import java.util.List;

/**
 * 用户信息查询
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月19日 下午3:19:18
 *
 */
public interface IModifyDemoService {
	String getDemoData();

	List<ModifyDemoBo> queryAll();
}
