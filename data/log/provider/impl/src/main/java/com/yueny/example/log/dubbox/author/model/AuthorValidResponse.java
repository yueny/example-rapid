/**
 *
 */
package com.yueny.example.log.dubbox.author.model;

import com.yueny.rapid.lang.mask.pojo.instance.AbstractMaskBo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 权限验证响应对象模型
 *
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年3月22日 下午8:57:27
 *
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorValidResponse extends AbstractMaskBo {
	/**
	 * 错误码
	 */
	private String code;
	/**
	 * 结果描述
	 */
	private String desc;
	/**
	 * 错误描述
	 */
	private String message;
	/**
	 * 验证结果
	 */
	private boolean valid;

}
