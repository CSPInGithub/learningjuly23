package org.hcl.tests;

import org.hcl.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class YatraTest extends BaseTest {
	/*
	 * Open www.Yatra.com Select option round trip In the “Depart from” field select
	 * option as “Pune, India (PNQ)” In the “Going to” field select the option as
	 * “New Delhi, India (DEL)” Select departure date as 14th July and return date
	 * as 15th July. Search for flights Validate if it is diverting to search result
	 * page.
	 */

	private YatraTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void testYatra() throws InterruptedException {
		
		By roundTrip = By.cssSelector(
				"div[class='trip-type mor-option']>ul[class='selc-flight-options'] li:nth-of-type(2) a[title='Round Trip']");
		Driver.driver.findElement(roundTrip).click();

		TypeInField("label[for='BE_flight_origin_city'] input", " Pune");

		Driver.driver.findElement(By.xpath("//div[@class='ac_results origin_ac']//li//p")).click();

		TypeInField("label[for='BE_flight_arrival_city'] input", " New Delhi");

		Driver.driver.findElement(By.xpath("//div[@class='ac_results dest_ac']//li//p")).click();

		selectDate("BE_flight_origin_date", "14/07/2023");
		selectDate("BE_flight_arrival_date", "15/07/2023");

		By flightFlsearchBtn = By.cssSelector("input[value='Search Flights'][id='BE_flight_flsearch_btn']");
		Driver.driver.findElement(flightFlsearchBtn).click();

		String actualSearchpagetitle = Driver.driver.getTitle();

		Assert.assertEquals(actualSearchpagetitle, "Yatra.com | Pune to Delhi flights");

	}

	public void TypeInField(String css, String value) throws InterruptedException {
		String val = value;
		WebElement element = Driver.driver.findElement(By.cssSelector(css));
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
		WebElement element1 = Driver.driver.findElement(By.cssSelector(label));
		element1.click();

		String bycss = String.format("tbody[class='%s'] td[id='%s']", cFORss, value);

		WebElement element = Driver.driver.findElement(By.cssSelector(bycss));

		element.click();
	}

}
