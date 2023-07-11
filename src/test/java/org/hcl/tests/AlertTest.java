package org.hcl.tests;

import org.hcl.pages.AlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

	@Test

	public void verifyJSAlert() {
		AlertPage alertpage = new AlertPage();
		alertpage.openAlertTestPage("http://the-internet.herokuapp.com/javascript_alerts");
		
		/* simpleAlert */
		alertpage.clickJsButton("Click for JS Alert", "simpleAlert", null);
		Assert.assertEquals(alertpage.getResult(), "You successfully clicked an alert");
		
		/* confirmationAlert */
		alertpage.clickJsButton("Click for JS Confirm", "confirmationAlert", null);
		Assert.assertEquals(alertpage.getResult(), "You clicked: Cancel");
		
		/* promptAlert */
		alertpage.clickJsButton("Click for JS Prompt", "promptAlert", "test prompt");
		Assert.assertEquals(alertpage.getResult(), "You entered:" + " test prompt");

	}

}
