package com.event;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_SimpleMath {

	private SimpleMath simplemath;
	
	@Before
	public void setup() {
		simplemath = new SimpleMath();
	}
	
	@Test
	public void test_findsum() {
		final int sumval = simplemath.sum(2, 3);
		assertEquals(5, sumval);
	}
	
	@Test
	public void test_findsubtraction() {
		final int diffval = simplemath.subtraction(4, 3);
		assertEquals(1, diffval);
	}
	
	@Test
	public void test_findmultiplication() {
		final int mulval = simplemath.multiplication(4, 3);
		assertEquals(12, mulval);
	}
	
	@Test
	public void test_finddivison() {
		int divval = 0;
		try {
			divval = simplemath.divison(4, 4);
		} catch (Exception e) {
			
		}
		assertEquals(1, divval);
	}
	
	@Test(expected=Exception.class)
	public void test_finddivison_neg() throws Exception {
		simplemath.divison(4, 0);		
	}
	
	@Test
	public void test_findequalIntegers() throws Exception {
		final boolean eqlval = simplemath.equalIntegers(4, 4);
		assertEquals(true, eqlval);
	}
	
	@Test
	public void test_findequalIntegers1() throws Exception {
		final boolean eqlval = simplemath.equalIntegers(4, 5);
		assertEquals(false, eqlval);
	}
	
	@After
	public void tearDown() {
		simplemath = null;
	}
}
