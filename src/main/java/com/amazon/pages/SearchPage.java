package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
	public List<WebElement> listOfProducts;

	@AndroidFindBy(xpath = "//*[contains(@text,'See all results for 65-inch tv.')]")
	public WebElement seeAllResultsLink;

	public SearchPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickToSeeAllResults() {
		Utilities.tapOnElement(seeAllResultsLink);
	}

	public void chooseARandomProduct() {
		int results = listOfProducts.size();
		int randomProduct = Utilities.generateRandomNumber(results);

		for (int element = 0; element < results; element++) {

			if (element == randomProduct) {
				listOfProducts.get(element).click();
				break;
			}
		}

	}
}