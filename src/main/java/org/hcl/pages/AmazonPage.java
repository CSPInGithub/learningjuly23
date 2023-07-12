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

	public void openAmazonHomePage(String url) {

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

}
