/**
 *
 */
package com.yueny.example.log.dubbox.author.model;

import com.yueny.rapid.lang.mask.pojo.instance.AbstractMaskBo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 权限验证对象模型
 *
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年3月22日 上午10:05:00
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorValidModel extends AbstractMaskBo {
	/**
	 * 用户账户
	 */
	@Getter
	@Setter
	private String authAcc;
	/**
	 * 用户凭证
	 */
	@Getter
	@Setter
	private String authCredential;
	/**
	 * 请求服务的接口地址(含方法)
	 */
	@Getter
	@Setter
	private String requestAPIService;
	/**
	 * 请求IP
	 */
	@Getter
	@Setter
	private String requestIp;
}
