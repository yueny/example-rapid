/**
 *
 */
package com.yueny.example.log.dubbox.author.inc;

import com.yueny.example.log.dubbox.author.model.AuthorValidModel;
import com.yueny.example.log.dubbox.author.model.AuthorValidResponse;

/**
 * 权限验证服务
 *
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年3月22日 上午10:02:55
 *
 */
public interface IAuthorValidService {
	/**
	 *
	 */
	AuthorValidResponse valid(AuthorValidModel authorValid);

}
