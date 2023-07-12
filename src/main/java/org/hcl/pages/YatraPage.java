package org.hcl.pages;

import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;

public class YatraPage extends SeleniumAction {
	/* inheritance */

	public YatraPage() {
		// TODO Auto-generated constructor stub
	}

	private By roundTrip = By.cssSelector(
			"div[class='trip-type mor-option']>ul[class='selc-flight-options'] li:nth-of-type(2) a[title='Round Trip']");
	private By flightFlsearchBtn = By.cssSelector("input[value='Search Flights'][id='BE_flight_flsearch_btn']");

	private By originresults = By.xpath("//div[@class='ac_results origin_ac']//li//p");

	private By destinationresults = By.xpath("//div[@class='ac_results dest_ac']//li//p");

	public void selectTrip() {
		click(roundTrip);
	}

	public void openHomePage(String url) {

		getURL(url);

	}

	public void selectToAndFrom() throws InterruptedException {
		typeInField("label[for='BE_flight_origin_city'] input", " Pune");
		click(originresults);
		typeInField("label[for='BE_flight_arrival_city'] input", " New Delhi");
		click(destinationresults);
	}

	public void selectDateForJourney(String fromDate, String todate) throws InterruptedException {
		selectDate("BE_flight_origin_date", fromDate);
		selectDate("BE_flight_arrival_date", todate);
	}

	public String searchResults() {
		click(flightFlsearchBtn);
		return getTitle();
	}

}
