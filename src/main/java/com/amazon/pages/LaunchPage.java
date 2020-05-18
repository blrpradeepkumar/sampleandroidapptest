package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchPage {
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Already a customer')]")
	public WebElement alreadyACustomerButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='New to Amazon.in? Create an account']")
	public WebElement createAnAccountButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Skip sign in']")
	public WebElement skipSignInButton;

	public LaunchPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOncreateAnAccountButton() {
		createAnAccountButton.click();
	}

	public void clickOnAlreadyCustomerButton() {
		alreadyACustomerButton.click();
	}

	public void clickOnSkipSignInButton() {
		skipSignInButton.click();
	}

}
