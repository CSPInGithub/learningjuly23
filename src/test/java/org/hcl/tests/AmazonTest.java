package org.hcl.tests;

import org.hcl.pages.AmazonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class AmazonTest extends BaseTest {

	private AmazonTest() {
		// TODO Auto-generated constructor stub
	}

	@Test

	public void selectAnyOptionFromList() {

		AmazonPage amazonPage = new AmazonPage();
		amazonPage.openAmazonHomePage("https://www.amazon.in/");
		String actual= amazonPage.selectItemFromAccountsAndLists("Baby Wishlist");
		
		Assert.assertTrue(actual.contains("Amazon: Baby Wish List"));

	}

}
