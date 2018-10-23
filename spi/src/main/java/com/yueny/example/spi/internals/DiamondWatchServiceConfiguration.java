/**
 * 
 */
package com.yueny.example.spi.internals;

import com.yueny.example.spi.spi.IWatchServiceConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * diamond 配置中心
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年9月5日 上午11:15:23
 */
@Slf4j
public class DiamondWatchServiceConfiguration implements IWatchServiceConfiguration {
	/**
	 * <p>
	 * 默认打马赛克的email字段， 值不可被修改
	 * </p>
	 * email</br>
	 * EMAIL</br>
	 * mail</br>
	 * emailAddr</br>
	 * emailAddress</br>
	 * email_addr</br>
	 * email_address</br>
	 */
	private static Set<String> defaultEmailFields = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("email")));
	/**
	 * <p>
	 * 默认打马赛克的字段， 值不可被修改
	 * </p>
	 * 身份证号码</br>
	 */
	private static Set<String> defaultMaskFields = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("cardNo",
			"phone")));

	/**
	 * <p>
	 * 默认打马赛克的email字段， 值不可被修改
	 * </p>
	 */
	private static Set<String> emailFields;
	/**
	 * <p>
	 * 默认打马赛克的字段， 值不可被修改
	 * </p>
	 */
	private static Set<String> maskFields;

	/* (non-Javadoc)
	 * @see com.aicai.fw.mask.spi.IWatchServiceConfiguration#getEmailFields()
	 */
	public Set<String> getEmailFields(){
		return emailFields;
	}

	/* (non-Javadoc)
	 * @see com.aicai.fw.mask.spi.IWatchServiceConfiguration#getMaskFields()
	 */
	public Set<String> getMaskFields(){
		return maskFields;
	}

	public boolean isBizMonitor(){
		return true;
	}

	@Override
	public boolean load(){
		maskFields = defaultMaskFields;
		emailFields = defaultEmailFields;

		return true;
	}

}
