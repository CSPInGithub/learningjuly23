package org.hcl.tests;

import org.hcl.pages.EbayPage;
import org.testng.annotations.Test;

public class EbayTest extends BaseTest {

	@Test(groups = {"assignment06"})

	public void verifyAllItemsInPage() {
		
		EbayPage ebay = new EbayPage();
		ebay.openHomePage("https://www.ebay.com/");
		ebay.selectFromDropdownAndSearch("selectByVisibleText", "Books");
		ebay.displayAllitemsOfPage("Books");
		

	}

}
