package com.amazon.test;

import org.testng.annotations.Test;
import com.amazon.pages.LaunchPage;

public class LaunchApplicationTest extends BaseTest {

	LaunchPage launchPage;

	@Test
	public void launchApplication() {
		
		launchPage = new LaunchPage(driver);
		launchPage.clickOnAlreadyCustomerButton();

	}

}
