package org.hcl.tests;

import org.hcl.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	

	protected BaseTest() {
		
	}
	
	@BeforeMethod
	/* @Parameters("url") */
	public void setup( ) {

		Driver.initDriver();

	}

	@AfterMethod
	public void tearDown() {
		Driver.tearDown();

	}
}
