package com.event.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.event.Test_SimpleMath;
import com.event.Test_UserRegistration;
import com.event.Test_UserService;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	Test_SimpleMath.class,
	Test_UserRegistration.class,
	Test_UserService.class
})
public class TestSuite {
	
}
