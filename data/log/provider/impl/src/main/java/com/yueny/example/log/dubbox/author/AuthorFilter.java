/**
 *
 */
package com.yueny.example.log.dubbox.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.dubbo.rpc.RpcResult;
import com.yueny.example.log.dubbox.author.inc.IAuthorValidService;
import com.yueny.example.log.dubbox.author.model.AuthorValidModel;
import com.yueny.example.log.dubbox.author.model.AuthorValidResponse;
import com.yueny.rapid.data.resp.pojo.response.BaseResponse;
import com.yueny.rapid.data.storage.dubbox.author.AuthorityContext;

import lombok.Setter;

/**
 * 服务提供方提供的访问权限验证
 *
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年3月22日 上午8:53:06
 *
 */
@Activate(group = { Constants.PROVIDER })
public class AuthorFilter implements Filter {
	/**
	 * 权限验证服务
	 */
	@Setter
	private IAuthorValidService authorValidService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Result invoke(final Invoker<?> invoker, final Invocation invocation) throws RpcException {
		if (invocation instanceof RpcInvocation) {
			((RpcInvocation) invocation).setInvoker(invoker);
		}

		final String authAcc = AuthorityContext.getContext().getAuthAcc();
		final String authCredential = (String) AuthorityContext.getContext().getAuthCredential();

		final RpcContext context = RpcContext.getContext();
		// 获取调用方IP地址
		final String clientIP = context.getRemoteHost();
		final String inter = context.getAttachment("interface");
		final StringBuilder sb = new StringBuilder();
		// 接口
		sb.append(inter);
		sb.append("#");
		// 方法名
		sb.append(invocation.getMethodName());
		// 参数类型

		final AuthorValidModel authorValid = AuthorValidModel.builder().authAcc(authAcc).authCredential(authCredential)
				.requestIp(clientIP).requestAPIService(sb.toString()).build();
		final AuthorValidResponse resp = authorValidService.valid(authorValid);

		if (!resp.isValid()) {
			final BaseResponse value = new BaseResponse();
			value.setCode(resp.getCode());
			value.setMessage(resp.getMessage());

			logger.warn("请求:{} 异常拦截：{}。", authorValid, resp);
			return new RpcResult(value);
		}

		return invoker.invoke(invocation);
	}

}
