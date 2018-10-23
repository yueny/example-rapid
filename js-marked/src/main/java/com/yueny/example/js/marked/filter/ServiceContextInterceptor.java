/**
 * 
 */
package com.yueny.example.js.marked.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 服务上下文初始化拦截器<br>
 * 
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年5月17日 下午3:36:29
 */
public class ServiceContextInterceptor extends HandlerInterceptorAdapter {
	/**
	 * ctx
	 */
	private String ctx;
	
	/**
	 * 构建一个新的上下文，填充以下内容： 1. 应用名 2. ctxLogId 3. X-TX-ID 4. X-REAL-IP 5.
	 * X-Client-IP
	 */
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		if (request.getAttribute("ctx") == null) {
			request.setAttribute("ctx", ctx);
		}
	
		return true;
	}
	
	public void setCtx(final String ctx) {
		this.ctx = ctx;
	}

}
