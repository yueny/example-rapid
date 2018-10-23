package com.yueny.example.proxy.service;

import com.yueny.example.proxy.bo.ModifyDemoBo;

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
	ModifyDemoBo queryByUserId(Long userId);

	List<ModifyDemoBo> queryAll();
}
