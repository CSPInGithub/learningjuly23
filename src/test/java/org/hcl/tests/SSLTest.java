package org.hcl.tests;

import org.hcl.pages.SSLPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SSLTest extends BaseTest {

	@Test
	@Parameters("mainmssg")
	public void verifySSL(String mainmssg) {

		SSLPage sslpage = new SSLPage();
		String actualTitle = sslpage.openSSLTestPage("https://cacert.org/");
		Assert.assertEquals(actualTitle, "Privacy error");
		Assert.assertEquals(sslpage.getMainMessage(), mainmssg);

	}

}
