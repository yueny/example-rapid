package com.yueny.example.log.service;

import com.yueny.rapid.data.resp.pojo.response.NormalResponse;

/**
 * 用户信息查询
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月19日 下午3:19:18
 *
 */
public interface IUserService {
	NormalResponse<Boolean> queryByUserId(Long userId);
}
