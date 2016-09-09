package com.event;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.event.constant.UserService;

public class Test_UserRegistration {

	private UserRegistration userReg;
	
	private User user;
		
	@Before
	public void setup() {
		userReg = new UserRegistration();
		user = new User();
	}
	
	@Test
	public void test_finduserreg() {
		user.setName(UserService.INSTANCE.getUserByPosition(0));
		user.setAge(25);
		user.setEmail("aa@gmail.com");
		boolean result = false;
		try {
			result = userReg.validate(user);
		} catch (RegistrationException e) {
			
		}
		assertEquals(true, result);
	}
	
	@Test(expected=RegistrationException.class)
	public void test_finduserage_neg() throws RegistrationException {
		User user = new User();
		user.setName("Abinaya");
		user.setAge(11);
		user.setEmail("aa@gmail.com");
		userReg.validate(user);		
	}
	
	@Test(expected=RegistrationException.class)
	public void test_finduseremail_neg() throws RegistrationException {
		User user = new User();
		user.setName("Abinaya");
		user.setAge(11);
		user.setEmail("");
		userReg.validate(user);		
	}
	
	@Test(expected=RegistrationException.class)
	public void test_findusername_neg() throws RegistrationException {
		User user = new User();
		user.setName("");
		user.setAge(25);
		user.setEmail("aa@gmail.com");
		userReg.validate(user);		
	}
	
	@After
	public void tearDown() {
		userReg = null;
		user = null;
	}
	
}
