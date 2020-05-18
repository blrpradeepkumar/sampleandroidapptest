package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnterUsernamePage{
	
	@AndroidFindBy(xpath = "//*[@text='Create account. New to Amazon?']")
	public WebElement createAccountRadioButton;
	
	@AndroidFindBy(xpath = "//*[@text='Login. Already a customer?']")
	public WebElement loginAlreadyACustomerRadioButton;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement emailOrPhoneTextBox;
	
	@AndroidFindBy(xpath = "//*[@text='Continue']")
	public WebElement continueButton;
	
	public EnterUsernamePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void enterUsername(String userName) {
		Utilities.tapOnElement(emailOrPhoneTextBox);
		emailOrPhoneTextBox.sendKeys(userName);
	}
	
	public void clickOnLoginAlreadyACustomerRadioButton() {
		loginAlreadyACustomerRadioButton.click();
	}
	
	public void clickOnContinueButton() {
		Utilities.tapOnElement(continueButton);
	}
	
}
