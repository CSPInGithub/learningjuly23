package org.hcl.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {
	
	
	
	@Test
	public void  test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[local-name()='svg' and @class='gb_h']/*[local-name()='path']")).click();
		
		Thread.sleep(60000);
		
		driver.quit();
	}
	

}
