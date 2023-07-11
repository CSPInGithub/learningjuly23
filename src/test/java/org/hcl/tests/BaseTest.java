package org.hcl.tests;

import org.hcl.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {

		Driver.initDriver(browser);

	}

	@AfterMethod
	public void tearDown() {
		Driver.tearDown();

	}
}
