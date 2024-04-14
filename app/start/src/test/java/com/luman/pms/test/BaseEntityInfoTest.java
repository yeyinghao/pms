package com.luman.pms.test;

import com.luman.pms.start.Application;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public abstract class BaseEntityInfoTest {

	@BeforeAll
	public static void init() {
		System.out.println("------开始测试------");
	}

	@AfterAll
	public static void after() {
		System.out.println("------测试结束------");
	}

}
