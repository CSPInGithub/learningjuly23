package org.hcl.pages;

import java.util.List;

import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class AmazonPage extends SeleniumAction {

	public AmazonPage() {
	}

	private By accountsAndLists = By.cssSelector("a[id='nav-link-accountList']");

	private By yourList = By.cssSelector("div[id='nav-al-wishlist'] div");

	private By yourListItems = By.xpath("//div[@id='nav-al-wishlist']//a/span");

	private By actualText = By.cssSelector("div[class='br-cls-div-homepage-logo'] img");

	private By mxAutotexCenter = By.xpath("//div[@class='mx-auto text-center p-4']/h1");

	private By ElementalSeleiumLink = By.cssSelector("div[style='text-align: center;'] a");

	private By seleniumCommunityLink = By
			.cssSelector("div[class='row footer__links'] div:nth-of-type(3) ul li:nth-of-type(2) a");

	public void openHomePage(String url) {

		getURL(url);

	}

	public String selectItemFromAccountsAndLists(String item) {

		hoverTo(accountsAndLists);
		System.out.println("clicking items under ------>>>" + getElement(yourList).getText());

		List<WebElement> list = getListOfItems(yourListItems);

		for (WebElement webElement : list) {

			if (webElement.getText().equalsIgnoreCase(item)) {

				click(webElement);
				break;

			}

		}

		return getElement(actualText).getAttribute("alt");

	}

	public String getText() {

		return getElement(mxAutotexCenter).getText();

	}

	public void multipleWindowshandle() {
		System.out.println(getTitle());
		click(ElementalSeleiumLink);

		switchToNewTab();

		System.out.println(getTitle());
		click(seleniumCommunityLink);

		switchToNewTab();
		System.out.println(getTitle());
		driverClose();

		switchToPreviousWindow();

	}

}
