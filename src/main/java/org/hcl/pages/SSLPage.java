package org.hcl.pages;

import org.hcl.utility.SeleniumAction;
import org.openqa.selenium.By;

public class SSLPage extends SeleniumAction {

	private By message = By.xpath("//div[@id='main-message']/h1");

	public String openSSLTestPage(String url) {

		getURL(url);

		return getTitle();

	}

	public String getMainMessage() {

		return getText(message);

	}

}
