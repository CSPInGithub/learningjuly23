package org.hcl.tests;

import org.hcl.pages.AmazonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class AmazonAndOtherMiscTest extends BaseTest {

	private AmazonAndOtherMiscTest() {
		// TODO Auto-generated constructor stub
	}

	@Test(enabled = false)

	public void selectAnyOptionFromList() {

		AmazonPage amazonPage = new AmazonPage();
		amazonPage.openHomePage("https://www.amazon.in/");
		String actual= amazonPage.selectItemFromAccountsAndLists("Baby Wishlist");
		
		Assert.assertTrue(actual.contains("Amazon: Baby Wish List"));

	}
	
	@Test(enabled = false)

	public void validateText() {

		AmazonPage page = new AmazonPage();
		page.openHomePage("https://www.selenium.dev/");
		Assert.assertEquals(page.getText(),"Selenium automates browsers. That's it!");
		

	}
	@Test

	public void multipleWindowCloseByClose() {

		AmazonPage page = new AmazonPage();
		page.openHomePage("https://the-internet.herokuapp.com/windows");
		page.multipleWindowshandle();
		
		

	}

}
