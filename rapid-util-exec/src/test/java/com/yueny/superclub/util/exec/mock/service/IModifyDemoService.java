package com.yueny.superclub.util.exec.mock.service;

import java.util.List;

import com.yueny.superclub.util.exec.mock.bo.ModifyDemoBo;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年8月5日 上午9:56:50
 *
 */
public interface IModifyDemoService {
	/**
	 * @return
	 */
	List<ModifyDemoBo> queryAll();

	List<Long> queryIds();
}
