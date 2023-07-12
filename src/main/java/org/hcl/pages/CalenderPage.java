package org.hcl.pages;

import java.util.List;

import org.hcl.utility.SeleniumAction;
import org.hcl.utility.genericUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class CalenderPage extends SeleniumAction {

	public CalenderPage() {
	}

	private By month = By.cssSelector("span[class='ui-datepicker-month']");
	private By year = By.cssSelector("span[class='ui-datepicker-year']");
	private By prev = By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-w']");

	// private By next = By.cssSelector("span[class='ui-icon
	// ui-icon-circle-triangle-e']");
	private By dateTextbox = By.cssSelector("input[id='datepicker']");

	private By currentdate = By.cssSelector(
			"table[class='ui-datepicker-calendar'] tbody tr td a[class='ui-state-default ui-state-highlight ui-state-hover']");

	private By otherDateThenCurrentDate = By
			.cssSelector("table[class='ui-datepicker-calendar'] tbody tr td a[class='ui-state-default']");

	public void openCalenderPage(String url) {

		getURL(url);

	}

	public void selectCurrentDate(String selectedDate) {

		click(dateTextbox);

		String[] parts = genericUtility.splitString(selectedDate, "-");

		String userday = parts[0];
		String usermonth = parts[1];
		String useryear = parts[2];

		String highightedDate = getElement(currentdate).getText();
		String calenderMonth = getElement(month).getText();
		String calenderYear = getElement(year).getText();

		if (highightedDate.equalsIgnoreCase(userday) && calenderMonth.equalsIgnoreCase(usermonth)
				&& calenderYear.equalsIgnoreCase(useryear)) {

			click(currentdate);

		}

	}

	public void selectProvidedDate(String birthDate) throws InterruptedException {

		click(dateTextbox);

		String[] parts = genericUtility.splitString(birthDate, "-");

		int expcetedDate = Integer.parseInt(parts[0]);
		String expcetedMonth = parts[1];
		int expcetedYear = Integer.parseInt(parts[2]);

		while (true) {
			// int currentDate = Integer.parseInt(getElement(currentdate).getText());
			String currentMonth = getElement(month).getText();
			int currentYear = Integer.parseInt(getElement(year).getText());

			if (currentYear == expcetedYear && currentMonth.equalsIgnoreCase(expcetedMonth)) {
				break;
			}

			click(prev);
		}
		List<WebElement> listOtherDate = getListOfItems(otherDateThenCurrentDate);

		for (WebElement webElement : listOtherDate) {
			if (Integer.parseInt(webElement.getText()) == expcetedDate) {
				webElement.click();
				Thread.sleep(3000);
				break;

			}

		}

	}

}
