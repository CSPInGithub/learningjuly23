package org.hcl.pages;

import java.util.List;

import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class EbayPage extends SeleniumAction {

	public EbayPage() {
	}

	private By allCategoriesDropDown = By.xpath("//select[@id='gh-cat']");
	private By searchBtn = By.xpath("//input[@id='gh-btn']");

	private By listOfItems = By.xpath("//ul[@class='b-list__items_nofooter']/li//h3[@class='s-item__title']");

	public void openHomePage(String url) {

		getURL(url);

	}

	public void selectFromDropdownAndSearch(String type, String value) {

		selectFromDropdown(allCategoriesDropDown, type, value);
		click(searchBtn);

	}

	public void displayAllitemsOfPage(String value) {

		String a = String.format("//p[text()='%s']/..", value);
		By itemLocator = By.xpath(a);
		click(itemLocator);
		List<WebElement> list = getListOfItems(listOfItems);

		list.stream().forEach(e -> System.out.println(e.getText()));
	}

}
