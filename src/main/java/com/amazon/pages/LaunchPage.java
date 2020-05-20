package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchPage {
	
	//Launch application page
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Already a customer')]")
	public WebElement alreadyACustomerButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='New to Amazon.in? Create an account']")
	public WebElement createAnAccountButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Skip sign in']")
	public WebElement skipSignInButton;
	
	@AndroidFindBy(xpath = "//*[@text='Create account. New to Amazon?']")
	public WebElement createAccountRadioButton;
	
	//Page to enter username
	@AndroidFindBy(xpath = "//*[@text='Login. Already a customer?']")
	public WebElement loginAlreadyACustomerRadioButton;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement emailOrPhoneTextBox;
	
	@AndroidFindBy(xpath = "//*[@text='Continue']")
	public WebElement continueButton;

	//Page to enter password
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement passwordTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']")
	public WebElement loginButton;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Show password']")
	public WebElement showPasswordCheckBox;
	
	
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
	
	public void enterPassword(String password) {
		Utilities.tapOnElement(passwordTextBox);
		passwordTextBox.sendKeys(password);
		
	}
	
	public void clickLoginButton() {
		
		Utilities.tapOnElement(loginButton);
	}	

}
