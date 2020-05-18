package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'65 inches')]")
	public WebElement productTitle;
	
	@AndroidFindBy(xpath = "//")
	public WebElement productPrice;
	
	public CartPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getTitleInCartPage() {
		return productTitle.getText();
	}
	
	public String getPriceInCartPage() {
		return productPrice.getText();
	}

}
