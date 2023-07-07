package org.hcl.utility;

import java.time.Duration;

import org.hcl.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAction {

	protected WebElement getElement(By by) {
		WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	protected void click(By by) {
		getElement(by).click();
	}

	protected void getURL(String url) {
		Driver.driver.get(url);
	}

	protected String getTitle() {
		return Driver.driver.getTitle();

	}
}
