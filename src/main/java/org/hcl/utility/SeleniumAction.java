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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAction {

	/* inheritance */

	protected SeleniumAction() {
		// TODO Auto-generated constructor stub
	}

	

	private  Set<String> allhandles;
	

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

	protected String getTitle() {
		return Driver.driver.getTitle();
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
	/*
	 * @Override public void get(String url) {
	 * Driver.getDriver().navigate().to(url); // Write the difference between the
	 * navigate() and get() method. // it has other methods as well like
	 * refresh,back and forward }
	 * 
	 * @Override public String getTitle() { return Driver.getDriver().getTitle();
	 * 
	 * }
	 */

	protected void hoverTo(By by) {

		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(getElement(by)).build().perform();

	}

	
	
	protected String getPageSource() {

		return Driver.getDriver().getPageSource();

	}

	protected void alert(String alertType, String text) {
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

	protected void selectFromDropdown(By by, String dropType, String value) {
		Select select = new Select(getElement(by));
		switch (dropType) {
		case "selectByIndex":

			select.selectByIndex(Integer.parseInt(value));

			break;
		case "selectByVisibleText":
			select.selectByVisibleText(value);
			break;
		case "confirmationAlert":
			select.selectByValue(value);
			break;
		default:
			System.out.println("incorrect dropType provided,pls chek again");
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

	protected List<WebElement> getListOfItems(By by) {

		return Driver.getDriver().findElements(by);

	}

	protected void driverClose() {

		Driver.getDriver().close();

	}
	protected void switchToNewTab(String parenthandle) {
		

		allhandles = Driver.getDriver().getWindowHandles();
		for (String handel : allhandles) {
			//newTabhandle = handel;

			if (!handel.equals(parenthandle)) {
				Driver.getDriver().switchTo().window(handel);
				break;

			}

		}
	}

	protected void switchToPreviousWindow(String parenthandle) {

		Driver.getDriver().switchTo().window(parenthandle);
		sleep(2000);
		driverClose();
		sleep(2000);

	}

	protected void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
