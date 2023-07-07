package org.hcl.tests;

import org.hcl.pages.MakeMyTripPage;
import org.testng.annotations.Test;

public final class MakeMyTripTest extends BaseTest {

	private MakeMyTripTest() {
		// TODO Auto-generated constructor stub
	}

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

		MakeMyTripPage makeMyTrip = new MakeMyTripPage();
		
		String title = makeMyTrip.openHomePageAndReturnPageTitle("https://www.makemytrip.com/");
		System.out.println("Page Title name : " + title);

		int titlelength = title.length();

		System.out.println("Page Title length is  : " + titlelength);

	}

}
