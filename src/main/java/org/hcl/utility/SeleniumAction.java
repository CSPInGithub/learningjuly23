package org.hcl.utility;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.hcl.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAction extends RemoteWebDriver {

	/* inheritance */

	protected SeleniumAction() {
		// TODO Auto-generated constructor stub
	}

	protected WebElement getElement(By by) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/*--------------------------------------------*/
	/* overloading within class */
	protected void click(By by) {
		getElement(by).click();
	}

	protected String getText(By by) {
		return getElement(by).getText();
	}

	protected void jsClick(By by) {

		JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

		executor.executeScript("arguments[0].click();", getElement(by));

	}

	protected void executeJsScript(String script) {

		JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

		executor.executeScript(script);

	}

	protected void click(WebElement element) {
		element.click();
	}

	protected void getURL(String url) {
		Driver.getDriver().get(url);
	}

	protected String getOpenedCurrentURL() {

		return Driver.getDriver().getCurrentUrl();
	}

	/*
	 * If the overridden method is public, then the overriding one must be only
	 * public.
	 */
	@Override
	public void get(String url) {
		Driver.getDriver().navigate().to(url);
		// Write the difference between the navigate() and get() method.
		// it has other methods as well like refresh,back and forward
	}

	@Override
	public String getTitle() {
		return Driver.getDriver().getTitle();

	}

	protected void hoverTo(By by) {

		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(getElement(by)).build().perform();

	}

	protected void driverClose() {

		Driver.getDriver().close();

	}

	protected void alert(String alertType,String text) {
		Alert alertObj = Driver.getDriver().switchTo().alert();
		switch (alertType) {
		case "simpleAlert":

			alertObj.accept();

			break;
		case "promptAlert":

			alertObj.sendKeys(text);
			alertObj.accept();

			break;
		case "confirmationAlert":

			String alertText = alertObj.getText();
			System.out.println("Alert text is " + alertText);
			alertObj.dismiss();

			break;
		default:
			System.out.println("incorrect alertypr provided,pls chek again");
			break;
		}

	}

	/*------------------------*/
	protected void typeInField(String css, String value) throws InterruptedException {
		String val = value;
		WebElement element = Driver.getDriver().findElement(By.cssSelector(css));
		element.click();

		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
			Thread.sleep(100);

		}
	}

	protected void selectDate(String loactorValue, String datevalue) throws InterruptedException {

		String label = String.format("label[for='%s']", loactorValue);
		WebElement element1 = Driver.getDriver().findElement(By.cssSelector(label));
		click(element1);

		String bycss = String.format("tbody[class='%s'] td[id='%s']", loactorValue, datevalue);

		WebElement element = Driver.getDriver().findElement(By.cssSelector(bycss));

		click(element);
	}

	protected void selectorClickItemFromListOfWebElements(By by, String item) {

		List<WebElement> list = Driver.getDriver().findElements(by);

		for (WebElement webElement : list) {

			String itemtext = webElement.getAttribute("href");
			if (itemtext.contains(item)) {
				jsClick(by);
				break;
			}

		}

	}

	protected void selectWindowTab(int position) {

		// String parentTab = Driver.getDriver().getWindowHandle();

		Set<String> handles = Driver.getDriver().getWindowHandles();

		String[] myArray = new String[handles.size()];
		handles.toArray(myArray);

		Driver.getDriver().switchTo().window(myArray[position]);

	}
}
