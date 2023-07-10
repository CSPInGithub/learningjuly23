package org.hcl.pages;

import java.util.Set;

import org.hcl.driver.Driver;
import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;

public class MyntraPage extends SeleniumAction {

	/*
	 * Open https://www.myntra.com/. Do mouse hovering on "MEN" option. You will get
	 * the all suboptions, there click on watches. In the filters under CATEGORIES
	 * -- check on Fitness bands. Select any color under the COLOR filter. On the
	 * right side you have dropdown "Sort by" -- select the option as Better
	 * Discount. Now choose any watch from the available options and read price and
	 * display it in the console of Eclipse.
	 */

	private By Men = By.cssSelector("div[class='desktop-navLinks'] div:nth-of-type(1) a[href='/shop/men']");

	private By itemsOnSortedPage = By.xpath("//div[@class='search-searchProductsContainer row-base']//ul/li//div[@class='product-productMetaInfo']/..");

	private By price = By.cssSelector("div[class='pdp-price-info'] p[class='pdp-discount-container'] strong");

	public void openHomePage(String url) {

		get(url);

	}

	public void selectsubOptionsFromMenMenu(String option) {

		hoverTo(Men);
		String Watches = String.format("div[class='desktop-categoryContainer'] li a[href='%s']", option);
		By watch = By.cssSelector(Watches);
		jsClick(watch);
	}

	public void selectFilterTypeAndValue(String filterType, String filterValue) throws InterruptedException {

		String df = String.format(
				"//span[text()='FILTERS']/..//following::div/span[text()='%s']/..//li//input[@value='%s']/..",
				filterType, filterValue);
		By reqd = By.xpath(df);
		jsClick(reqd);
		Thread.sleep(3000);

	}

	public String sortItems(String sortType) throws InterruptedException {

		String a = String.format(
				"document.querySelector(\"div[class='horizontal-filters-sortContainer'] div[class='sort-sortBy'] li input[value='%s']\").click()",
				sortType);
		executeJsScript(a);
		Thread.sleep(4000);
		return getOpenedCurrentURL();
	}

	public String readPriceAndDisplayOfItem(String item) {

		selectorClickItemFromListOfWebElements(itemsOnSortedPage, item);
		
		String parent = Driver.getDriver().getWindowHandle();
		Set<String> handles = Driver.getDriver().getWindowHandles();

		String[] myArray = new String[handles.size()];
		handles.toArray(myArray);

		Driver.getDriver().switchTo().window(myArray[1]);
		//selectWindowTab(1);
		String priceOfClickedItem = getElement(price).getText();

		driverClose();
		
		Driver.getDriver().switchTo().window(parent);
		return priceOfClickedItem;

	}

}
