package com.amazon.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.amazon.pages.EnterPasswordPage;
import com.amazon.utilities.Utilities;

public class EnterPasswordPageTest extends BaseTest{
	
	EnterPasswordPage enterPasswordPage;
	
	@Test(dataProviderClass = Utilities.class,dataProvider="dataprovider")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException {
		
		enterPasswordPage = new EnterPasswordPage(driver);
		Thread.sleep(5000);
		enterPasswordPage.enterPassword(data.get("password"));
		Thread.sleep(2000);
		enterPasswordPage.clickLoginButton();
	}

}
