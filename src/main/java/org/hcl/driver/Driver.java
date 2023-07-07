package org.hcl.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Driver {
	
	private Driver() {
		
	}
	
	public static WebDriver driver;
	
	public static void initDriver() {
		if (Objects.isNull(driver)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			//driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
	}
	
	public static void tearDown() {
		if (Objects.nonNull(driver)) {
			try {
				driver.close();

			} finally {
				driver.quit();
				driver = null;
			}
		}
	}

}
