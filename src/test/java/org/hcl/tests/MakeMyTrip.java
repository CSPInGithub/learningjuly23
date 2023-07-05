package org.hcl.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {

	
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
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String title = driver.getTitle();
		System.out.println("Page Title name : " + title);
		
		int titlelength = title.length();
		
		System.out.println("Page Title length is  : " + titlelength);
		
		driver.quit();

	}

}
