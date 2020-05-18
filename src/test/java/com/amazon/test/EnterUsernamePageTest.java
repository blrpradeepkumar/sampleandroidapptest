package com.amazon.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.amazon.pages.EnterUsernamePage;
import com.amazon.utilities.Utilities;

public class EnterUsernamePageTest extends BaseTest{

	EnterUsernamePage loginPage;
	
	@Test(dataProviderClass = Utilities.class,dataProvider="dataprovider")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException {
		
		loginPage = new EnterUsernamePage(driver);
		Thread.sleep(5000);
		loginPage.enterUsername(data.get("username"));
		loginPage.clickOnContinueButton();

	}

}
