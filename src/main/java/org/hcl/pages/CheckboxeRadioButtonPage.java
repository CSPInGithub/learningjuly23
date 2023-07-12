package org.hcl.pages;

import java.util.List;

import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class CheckboxeRadioButtonPage extends SeleniumAction {

	public CheckboxeRadioButtonPage() {
		// TODO Auto-generated constructor stub
	}

	private By radioButtonList = By.xpath("//form[@id='radio-buttons']/input");
	private By checkboxesList = By.xpath("//div[@id='checkboxes']/label");

	public void openTestPage(String url) {

		getURL(url);

	}

	public void displaytextLabel() {

		List<WebElement> list = getListOfItems(radioButtonList);

		list.stream().forEach(a -> System.out.println(a.getAttribute("value")));

	}

	public long getsizeOfCheckBoxes() {

		List<WebElement> listcheckBoxes = getListOfItems(checkboxesList);

		return listcheckBoxes.stream().count();

	}

	/*
	 * Check if the checkbox 'I have a car' is checked already, if no then check on
	 * it
	 */
	public void checkCheckBoxIsChecked(String value) {

		String a = String.format("//div[@id='checkboxes']/label/input[@value='%s']", value);
		By checkBox = By.xpath(a);
		String option = getElement(checkBox).getAttribute("value").toString();
		if (!getElement(checkBox).isSelected()) {
			System.out.println(option + "is not selected ");
			click(checkBox);

			System.out.println(option + "after chceking its been checked ");
		}

	}

}
