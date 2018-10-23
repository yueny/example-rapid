package com.yueny.example.log.service;

import com.yueny.rapid.data.resp.pojo.response.NormalResponse;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月19日 下午3:19:18
 *
 */
public interface IUserLogTraceService {
	NormalResponse<Integer> execute();

	NormalResponse<Integer> ugs();
}
