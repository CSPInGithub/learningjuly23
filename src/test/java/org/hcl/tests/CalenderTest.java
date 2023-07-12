package org.hcl.tests;

import org.hcl.pages.CalenderPage;
import org.testng.annotations.Test;

public final class CalenderTest extends BaseTest {

	private CalenderTest() {
		// TODO Auto-generated constructor stub
	}

	@Test

	public void verfiySelctionCurrentdate() {

		CalenderPage calenderpage = new CalenderPage();
		calenderpage.openCalenderPage(
				"https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		calenderpage.selectCurrentDate("12-July-2023");

	}

	@Test

	public void verfiySelctionDynanicdate() throws InterruptedException {

		CalenderPage calenderpage = new CalenderPage();
		calenderpage.openCalenderPage(
				"https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		calenderpage.selectProvidedDate("12-July-2021");

	}

}
