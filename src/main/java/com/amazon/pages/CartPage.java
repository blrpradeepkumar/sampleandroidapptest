package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.interfaces.Product;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage implements Product{
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@text,'65 inches')]")
	private WebElement productTitle;
	
	@AndroidFindBy(className = "android.widget.ListView")
	private List<WebElement> productPrice;
	
	public CartPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getTitleInCartPage() {
		return productTitle.getText();
	}
	
	public List<WebElement> getProductPrice() {
		return productPrice;
	}

	@Override
	public double getPrice() {
		String price = productPrice.get(0).getText();
		return Double.parseDouble(price);
	}

	@Override
	public String getProductTitle() {
		return productTitle.getText();
	}

}