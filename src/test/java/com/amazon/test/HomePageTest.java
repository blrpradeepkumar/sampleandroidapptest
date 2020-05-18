package com.amazon.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.amazon.pages.HomePage;
import com.amazon.utilities.Utilities;

public class HomePageTest extends BaseTest {
	
	HomePage homePage;
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dataprovider")
	public void homePage(Hashtable<String,String> data) {
		
		homePage = new HomePage(driver);
		homePage.enterDetailsinSearchTextBox(data.get("searchForElement"));
		
		
	}

}
