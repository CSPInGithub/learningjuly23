package org.hcl.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YatraTest {
	WebDriver driver;

	/*
	 * Open www.Yatra.com Select option round trip In the “Depart from” field select
	 * option as “Pune, India (PNQ)” In the “Going to” field select the option as
	 * “New Delhi, India (DEL)” Select departure date as 14th July and return date
	 * as 15th July. Search for flights Validate if it is diverting to search result
	 * page.
	 */
	@Test
	public void testYatra() throws InterruptedException {

		
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.get("https://www.yatra.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			By roundTrip = By.cssSelector(
					"div[class='trip-type mor-option']>ul[class='selc-flight-options'] li:nth-of-type(2) a[title='Round Trip']");
			driver.findElement(roundTrip).click();

			TypeInField("label[for='BE_flight_origin_city'] input", " Pune");

			driver.findElement(By.xpath("//div[@class='ac_results origin_ac']//li//p")).click();

			TypeInField("label[for='BE_flight_arrival_city'] input", " New Delhi");

			driver.findElement(By.xpath("//div[@class='ac_results dest_ac']//li//p")).click();

			selectDate("BE_flight_origin_date", "14/07/2023");
			selectDate("BE_flight_arrival_date", "15/07/2023");

			By flightFlsearchBtn = By.cssSelector("input[value='Search Flights'][id='BE_flight_flsearch_btn']");
			driver.findElement(flightFlsearchBtn).click();

			String actualSearchpagetitle = driver.getTitle();

			Assert.assertEquals(actualSearchpagetitle, "Yatra.com | Pune to Delhi flights");
			
		} finally {
			driver.close();

			driver.quit();
		}
		

		

	}

	public void TypeInField(String css, String value) throws InterruptedException {
		String val = value;
		WebElement element = driver.findElement(By.cssSelector(css));
		element.click();

		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
			Thread.sleep(100);

		}
	}

	public void selectDate(String cFORss, String value) throws InterruptedException {

		String label = String.format("label[for='%s']", cFORss);
		WebElement element1 = driver.findElement(By.cssSelector(label));
		element1.click();

		String bycss = String.format("tbody[class='%s'] td[id='%s']", cFORss, value);

		WebElement element = driver.findElement(By.cssSelector(bycss));

		element.click();
	}

}
