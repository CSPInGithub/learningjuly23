package org.hcl.tests;

import org.hcl.pages.SSLPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SSLTest extends BaseTest {

	@Test
	@Parameters("mainmssg")
	public void verifySSL(String mainmssg) {

		SSLPage sslpage = new SSLPage();
		//String actualTitle = sslpage.openSSLTestPage("https://cacert.org/");
		//String actualMessage = sslpage.getMainMessage();

		SoftAssert softAssert = new SoftAssert();
		//softAssert.assertEquals(actualTitle, "Privacy error", "title not matching....");
		//softAssert.assertEquals(actualMessage, mainmssg, "mssg not matching...");
		softAssert.assertAll();

	}

}
