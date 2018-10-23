/**
 *
 */
package com.yueny.example.log.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yueny.example.log.service.IUserService;
import com.yueny.rapid.data.resp.pojo.response.NormalResponse;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月19日 下午9:06:52
 *
 */
public class UserService implements IUserService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.yueny.example.log.service.IUserService#queryByUserId(java.lang.Long)
	 */
	@Override
	public NormalResponse<Boolean> queryByUserId(final Long userId) {
		logger.info("获取用户信息, 求情参数：{}，serverIP form consumer: {}, serverPort :{}.", userId,
				RpcContext.getContext().getRemoteHost(), RpcContext.getContext().getRemotePort());

		final NormalResponse<Boolean> resp = new NormalResponse<>();
		resp.setData(true);
		return resp;
	}

}
