package org.hcl.tests;

import org.hcl.pages.YatraPage;
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

		YatraPage yatra = new YatraPage();
		yatra.openHomePage("https://www.yatra.com/");
		yatra.selectTrip();
		yatra.selectToAndFrom();
		yatra.selectDateForJourney("14/07/2023", "15/07/2023");
		Assert.assertEquals(yatra.searchResults(), "Yatra.com | Pune to Delhi flights");
		
	}

}
