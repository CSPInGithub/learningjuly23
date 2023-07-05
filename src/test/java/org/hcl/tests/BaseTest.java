package org.hcl.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	static WebDriver driver = null;

	@BeforeMethod
	public void setup() {

		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			try {
				driver.close();

			} finally {
				driver.quit();
				driver = null;
			}
		}

	}
}
