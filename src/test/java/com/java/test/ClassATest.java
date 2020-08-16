package com.java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClassATest {

	@Test
	public void testPlusSuccess() {
		ClassA classA = new ClassA();
		int actual = classA.plus(100);
		int expected = 101;

		assertEquals(expected, actual);
	}
}
