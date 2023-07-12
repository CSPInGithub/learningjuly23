package org.hcl.tests;

import org.hcl.pages.CheckboxeRadioButtonPage;
import org.testng.annotations.Test;

public final class CheckboxeRadioButtonTest extends BaseTest {

	private CheckboxeRadioButtonTest() {
		// TODO Auto-generated constructor stub
	}

	@Test

	public void radioButton() {

		CheckboxeRadioButtonPage page = new CheckboxeRadioButtonPage();
		page.openTestPage("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

		page.displaytextLabel();
		System.out.println("count of checkboxes are :" + page.getsizeOfCheckBoxes());

		page.checkCheckBoxIsChecked("option-2");

	}

}
