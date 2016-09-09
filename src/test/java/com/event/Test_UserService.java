package com.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.event.constant.UserService;

public class Test_UserService {

	private static UserService userSer;

	@BeforeClass
	public static void setup() {
		userSer = UserService.INSTANCE;
	}

	@Test
	public void test_getUsersByName() {

		List<String> res = userSer.getUsersByName("Bofur");
		assertNotNull("List is not null", res);

	}

	@Test
	public void test_getPosition() {

		String res = userSer.getUserByPosition(3);
		assertEquals("Nori", res);

	}

	@AfterClass
	public static void tearDown() {
		userSer = null;
	}
}
