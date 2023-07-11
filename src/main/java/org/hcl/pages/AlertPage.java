package org.hcl.pages;

import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;

public final class AlertPage extends SeleniumAction {

	public AlertPage() {

	}

	
	private By result= By.xpath("//p[@id='result']");
	public void openAlertTestPage(String url) {

		getURL(url);

	}

	public void clickJsButton(String btnvalue, String alertType,String text) {

		String buttonXpath = String.format("//button[text()='%s']", btnvalue);
		By button = By.xpath(buttonXpath);
		click(button);
		alert(alertType,text);

	}
	public String getResult() {

		return getText(result);

	}

}
