/**
 *
 */
package com.yueny.example.log.service.author;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.yueny.example.log.dubbox.author.inc.IAuthorValidService;
import com.yueny.example.log.dubbox.author.model.AuthorValidModel;
import com.yueny.example.log.dubbox.author.model.AuthorValidResponse;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年3月22日 上午10:06:44
 *
 */
@Service(value = "authorValidService")
public class AuthorValidService implements IAuthorValidService {
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.yueny.example.log.service.author.IAuthorValidService#valid(com.yueny.
	 * example.log.bo.AuthorValidModel)
	 */
	@Override
	public AuthorValidResponse valid(final AuthorValidModel authorValid) {
		final String acc = "yuanyang";
		final String pw = "hahah";
		final String code = "00009999";
		final String message = "操作拒绝";

		// 权限信息验证
		if (!StringUtils.equals(authorValid.getAuthAcc(), acc)
				|| !StringUtils.equals(authorValid.getAuthCredential(), pw)) {
			return AuthorValidResponse.builder().code(code).message(message).valid(false).desc("权限信息有误").build();
		}

		return AuthorValidResponse.builder().code("00000000").message("验证通过").valid(true).desc("验证通过").build();
	}

}
