package org.hcl.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

	public static void initDriver(String browser) {
		if (Objects.isNull(getDriver())) {

			switch (browser) {
			case "chrome":
				ChromeOptions chromeOption = new ChromeOptions();
				chromeOption.addArguments("--disable-notifications");
				chromeOption.addArguments("--ignore-certificate-errors");
				driver = new ChromeDriver(chromeOption);

				break;
			case "edge":
				EdgeOptions edgeOption = new EdgeOptions();
				edgeOption.addArguments("--disable-notifications");
				edgeOption.addArguments("--ignore-certificate-errors");
				driver = new EdgeDriver(edgeOption);

				break;
			default:
				System.out.println("provided browser is not available pls try again with valid ones");
				break;
			}

			setDriver(driver);
			System.out.println("browser :======>>" + browser + " <<====== opened and scripts are executing.....");

			getDriver().manage().window().maximize();
			// driver.get(url);
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

	}

	public static void tearDown() {
		if (Objects.nonNull(getDriver())) {
			try {
				getDriver().close();

			} finally {
				getDriver().quit();
				// getDriver() = null;
				unloaDriver();
			}
		}
	}

}
