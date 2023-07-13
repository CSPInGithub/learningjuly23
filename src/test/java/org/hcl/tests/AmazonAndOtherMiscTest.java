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
		String actual = amazonPage.selectItemFromAccountsAndLists("Baby Wishlist");

		Assert.assertTrue(actual.contains("Amazon: Baby Wish List"));

	}

	@Test(enabled = false)

	public void validateText() {

		AmazonPage page1 = new AmazonPage();
		page1.openHomePage("https://www.selenium.dev/");
		Assert.assertEquals(page1.getText(), "Selenium automates browsers. That's it!");
		String src = page1.getPageSrc();
		Assert.assertTrue(src.contains("Selenium automates browsers"));

	}

	@Test(enabled = true)

	public void multipleWindowCloseByClose() {

		AmazonPage page = new AmazonPage();
		page.openHomePage("https://the-internet.herokuapp.com/windows");
		page.multipleWindowshandle();

	}

}
