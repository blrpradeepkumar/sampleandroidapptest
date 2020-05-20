package com.amazon.test;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.base.BaseClass;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LaunchPage;
import com.amazon.pages.SearchPage;
import com.amazon.utilities.Utilities;

public class ProductSearchTest extends BaseClass {

	LaunchPage launchPage;
	HomePage homePage;
	SearchPage searchPage;
	CartPage cartPage;

	@Test(priority = 0)
	public void launchingApplication() {

		// Landing page after launching the application
		launchPage = new LaunchPage(driver);
		log.debug("Application launched");

		launchPage.clickOnAlreadyCustomerButton();

	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dataprovider", dependsOnMethods = {
			"launchingApplication" }, priority = 1)
	public void userNamePage(Hashtable<String, String> data) {
		// Enter username page
		log.debug("On username prompt page");
		
		if (launchPage.loginAlreadyACustomerRadioButton.isEnabled()) {
			launchPage.enterUsername(data.get("username"));
			launchPage.clickOnContinueButton();
		}
		log.debug("Username entered is : " + data.get("username"));
	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dataprovider", dependsOnMethods = {
			"userNamePage" }, priority = 2)
	public void passwordPage(Hashtable<String, String> data) {
		// Enter password page
		log.debug("On password prompt page");
		if (launchPage.showPasswordCheckBox.isDisplayed()) {
			launchPage.enterPassword(data.get("password"));
			launchPage.clickLoginButton();
		}
		log.debug("Password entered is : " + data.get("password"));
	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dataprovider", dependsOnMethods = {
			"passwordPage" }, priority = 3)
	public void homePageValidation(Hashtable<String, String> data) {
		// Home page to search for products
		homePage = new HomePage(driver);
		log.debug("On application home page");
		if (homePage.getEnglishCheckBox().isDisplayed()) {
			homePage.clickOnEnglishCheckbox();
			homePage.clickOnSaveChangesButton();
			homePage.enterDetailsinSearchTextBox(data.get("searchtext"));
			homePage.selectProductFromList();
		} else {
			homePage.enterDetailsinSearchTextBox(data.get("searchtext"));
			homePage.selectProductFromList();
		}
		log.debug("product searched is : " + data.get("searchtext"));
	}

	@Test(dependsOnMethods = { "homePageValidation" }, priority = 4)
	public void searchForProduct() {
		// Search page displaying list of products
		searchPage = new SearchPage(driver);

		searchPage.clickToSeeAllResults();
		searchPage.chooseARandomProduct();
	}

	@Test(dependsOnMethods = { "searchForProduct" }, priority = 5)
	public void selectedProduct() {
		// Product page displaying the selected product
		String titleOfProduct = searchPage.getProductTitle();
		String priceOfProduct = searchPage.getProductPrice();
		searchPage.clickOnAddtoCartButton();
		searchPage.clickOnCartButton();

		// Cart page displaying the product in the cart
		cartPage = new CartPage(driver);
		String titleOnCartPage = cartPage.getTitleInCartPage();
		String priceOnCartPage = cartPage.getPriceInCartPage();

		// Validating title on both pages
		Assert.assertEquals(titleOfProduct, titleOnCartPage, "The product title on both the pages do not match");

		// Validating price on both pages
		Assert.assertEquals(priceOfProduct, priceOnCartPage, "The product price on both the pages do not match");
	}

}