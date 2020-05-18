package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'(65 inches)')]")
	public WebElement productTitle;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'rupees')]")
	public WebElement productPrice;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add to Cart']")
	public WebElement addToCartButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Cart']")
	public WebElement cartButton;
	
	public ProductPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getProductTitle() {
		return productTitle.getText();
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public void clickOnAddtoCartButton() {
		addToCartButton.click();
	}
	
	public void clickOnCartButton() {
		cartButton.click();
	}

}
