package org.hcl.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public final class Driver {
	
	private Driver() {
		
	}
	public static WebDriver driver;
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {

        return dr.get();

    }

    public static void setDriver(WebDriver driver) {

        dr.set(driver);

    }

    public static void unloaDriver() {

        dr.remove();

    }
	
	
	
	public static void initDriver() {
		if (Objects.isNull(getDriver())) {
			EdgeOptions options = new EdgeOptions();
			//options.addArguments("--disable-notifications");

			// WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver(options);
			
			setDriver(driver);

			getDriver().manage().window().maximize();
			//driver.get(url);
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
	}
	
	public static void tearDown() {
		if (Objects.nonNull(getDriver())) {
			try {
				getDriver().close();

			} finally {
				getDriver().quit();
				//getDriver() = null;
				unloaDriver();
			}
		}
	}

}
