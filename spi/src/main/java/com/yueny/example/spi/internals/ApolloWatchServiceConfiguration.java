/**
 * 
 */
package com.yueny.example.spi.internals;

import java.util.*;

import com.yueny.example.spi.spi.IWatchServiceConfiguration;
import lombok.extern.slf4j.Slf4j;

/**
 * apollo配置中心
 *
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年9月5日 上午11:15:23
 */
@Slf4j
public class ApolloWatchServiceConfiguration implements IWatchServiceConfiguration {
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
	private static Set<String> defaultEmailFields = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("email", "EMAIL", "mail", "emailAddr", "emailAddress",
			// 以下是针对_分隔的情况
			"email_addr", "email_address")));
	/**
	 * <p>
	 * 默认打马赛克的字段， 值不可被修改
	 * </p>
	 * 身份证号码</br>
	 */
	private static Set<String> defaultMaskFields = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("cardNo", "bankCard", "bankCardNo", "certificateNo", "certNo",
			//"mobile", "mobileNo", "tel", "telNo", "telphone", "telphoneNo", "phone", "phoneNo",
			"address", "addr", "postAddr", "postAddress", "mailAddr", "mailAddress",
			// 以下是针对遗留数据库增加f_前缀的情况
			"fCardNo", "fBankCard", "fBankCardNo", "fAccountNo", "fCertificateNo", "fCertNo", "fMobile", "fMobileNo",
			"fTel", "fTelNo", "fAddress", "fAddr", "fPostAddr", "fPostAddress", "fMailAddr", "fMailAddress",
			"fTelphone", "fTelphoneNo", "fPhone", "fPhoneNo",
			// 以下是针对_分隔的情况
			"card_no", "bank_card", "bank_card_no", "certificate_no", "cert_no",
			// "mobile_no", "tel_no", "telphone_no", "phone_no", "account_no"
			"post_addr", "post_address", "mail_addr", "mail_address")));

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

	static {
		maskFields = defaultMaskFields;
		emailFields = defaultEmailFields;
	}

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
	
}
