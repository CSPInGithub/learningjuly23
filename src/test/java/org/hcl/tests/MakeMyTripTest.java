package org.hcl.tests;

import org.testng.annotations.Test;

public class MakeMyTripTest extends BaseTest {

	/*
	 * 2.Write a code to open www.makemytrip.com
	 * 
	 * Get Page Title name and Title length
	 * 
	 * Print Page Title and Title length on the Eclipse Console.
	 * 
	 * Close the browser.
	 */
	@Test
	public void testMakeMyTrip() {

		

		String title = driver.getTitle();
		System.out.println("Page Title name : " + title);

		int titlelength = title.length();

		System.out.println("Page Title length is  : " + titlelength);

		

	}

}
