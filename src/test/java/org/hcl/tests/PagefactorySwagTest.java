package org.hcl.tests;

import org.hcl.pages.PagefactorySwagPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PagefactorySwagTest {

	@Test
	public void verifyPagefactory() {
      
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        
        PagefactorySwagPage loginPage = new PagefactorySwagPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        
        Assert.assertEquals(loginPage.getTile(), "Swag Labs");
        
        driver.quit();
    }
}
