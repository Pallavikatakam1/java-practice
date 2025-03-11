package com.questk2.demo;


public class MathsTest {
	@Test
	public void testAddition() {
		Maths maths = new Maths();
		assertEquals(5,maths.operations(1, 4));
	}
}
