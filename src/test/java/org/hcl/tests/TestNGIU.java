package org.hcl.tests;

import org.testng.annotations.Test;

public class TestNGIU {
	
	@Test(priority=10)
	public void M1() {
		System.out.println("m1");
	}

	@Test
	public void A2() {
		System.out.println("m2");
	}
	
	@Test(priority=1)
	public void M3() {
		System.out.println("m3");
	}
	
	@Test
	public void M4() {
		System.out.println("m4");
	}
}
