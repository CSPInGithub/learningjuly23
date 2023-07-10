package org.hcl.tests;

import org.hcl.pages.MyntraPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyntraTest extends BaseTest {

	@Test

	public void testMyntra() throws InterruptedException {

		MyntraPage myntra = new MyntraPage();
		myntra.openHomePage("https://www.myntra.com/");
		myntra.selectsubOptionsFromMenMenu("/mens-watches");

		myntra.selectFilterTypeAndValue("Categories", "Fitness Bands");
		myntra.selectFilterTypeAndValue("Color", "Black");

		System.out.println("current Url " + myntra.sortItems("discount"));

		Assert.assertTrue(myntra.sortItems("discount").contains("Color%3ABlack_36454f&sort=discount"));

		String price = myntra.readPriceAndDisplayOfItem("nuband");

		System.out.println("price of cliked item is : " + price);

		Assert.assertTrue(price.equalsIgnoreCase("₹1399"));

	}

	@Test

	public void testSoftAssertion() throws InterruptedException {

		MyntraPage myntra = new MyntraPage();
		myntra.openHomePage("https://www.myntra.com/");
		myntra.selectsubOptionsFromMenMenu("/mens-watches");

		myntra.selectFilterTypeAndValue("Categories", "Fitness Bands");
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(myntra.sortItems("discount"),
				"https://www.myntra.com/mens-watches?f=Categories%3AFitness%20Bands&sort=recommended",
				"url is not Matching");

		softAssert.assertEquals(myntra.readPriceAndDisplayOfItem("nuband"), "₹2399", "price is not Matching");
		softAssert.assertAll();

	}
}
