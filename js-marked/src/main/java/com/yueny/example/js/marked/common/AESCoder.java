//package com.yueny.example.js.marked.common;
//
//import com.yueny.superclub.util.crypt.core.AbstractCoder;
//import com.yueny.superclub.util.crypt.core.Base64Coder;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.spec.SecretKeySpec;
//
///**
// * AES， 已迁移至  com.yueny.superclub.util.crypt.core.AESCoder
// *
// * @category 基础加密组件
// *
// * @author 袁洋 2014年10月2日
// */
//public abstract class AESCoder extends AbstractCoder {
//	private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";
//
//	/**
//	 * 字节数组解密
//	 *
//	 * @param decryptData
//	 *            解密数据字节数组
//	 * @return 明文字节数组
//	 */
//	public final static String decrypt(final byte[] decryptData, String decryptKey) {
//		try {
//			KeyGenerator kgen = KeyGenerator.getInstance("AES");
//			kgen.init(128);
//
//			Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
//			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
//			byte[] decryptBytes = cipher.doFinal(decryptData);
//
//			return new String(decryptBytes);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	/**
//	 * 字符串解密，采用BASE64的算法
//	 *
//	 * @param decryptData
//	 *            解密数据字符串
//	 * @return 明文字节数组
//	 */
//	public final static String decrypt(final String decryptData, String decryptKey) {
//		return decrypt(Base64Coder.decrypt(decryptData), decryptKey);
//	}
//
//
//	/**
//	 * 采用算法对字节数组进行加密
//	 *
//	 * @param encryptData
//	 *            原字符串
//	 * @return 密文字符串
//	 */
//	public final static byte[] encryptToBytes(final String encryptData, String encryptKey) {
//		try{
//			KeyGenerator kgen = KeyGenerator.getInstance("AES");
//			kgen.init(128);
//			Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
//			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
//
//			return cipher.doFinal(encryptData.getBytes("utf-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	/**
//	 * 采用BASE64算法对字符串进行加密
//	 *
//	 * @param encryptData
//	 *            原字符串
//	 * @return 密文字符串
//	 */
//	public final static String encrypt(final String encryptData, String encryptKey) {
//		return Base64Coder.encrypt(encryptToBytes(encryptData, encryptKey));
//	}
//
//}
