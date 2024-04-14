package com.luman.pms.test.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;

/**
 * 加解密
 */
public class JasyptTest {

	@Test
	public void jasyptTest() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		// 加密所需的salt(盐)
		textEncryptor.setPassword("jasypt");
		// 要加密的数据（数据库的用户名或密码）
		String encrypt = textEncryptor.encrypt("abc191935");
		System.out.println("ENC(" + encrypt + ")");
		System.out.println(textEncryptor.decrypt(encrypt));
	}

}
