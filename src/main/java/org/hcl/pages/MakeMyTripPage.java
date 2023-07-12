package org.hcl.pages;

import org.hcl.utility.SeleniumAction;

public final class MakeMyTripPage extends SeleniumAction {

	public MakeMyTripPage() {

	}

	public String openHomePageAndReturnPageTitle(String url) {

		getURL(url);
		return getTitle();

	}

	

}
