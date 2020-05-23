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
	private WebElement alreadyACustomerButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='New to Amazon.in? Create an account']")
	private WebElement createAnAccountButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Skip sign in']")
	private WebElement skipSignInButton;
	
	
	@AndroidFindBy(xpath = "//*[@text='Create account. New to Amazon?']")
	private WebElement createAccountRadioButton;
	
	//Page to enter username
	@AndroidFindBy(xpath = "//*[@text='Login. Already a customer?']")
	private WebElement loginAlreadyACustomerRadioButton;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement emailOrPhoneTextBox;
	
	@AndroidFindBy(xpath = "//*[@text='Continue']")
	private WebElement continueButton;

	//Page to enter password
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement passwordTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']")
	private WebElement loginButton;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Show password']")
	private WebElement showPasswordCheckBox;
	
	public LaunchPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public WebElement getAlreadyACustomerButton() {
		return alreadyACustomerButton;
	}

	public WebElement getCreateAnAccountButton() {
		return createAnAccountButton;
	}

	public WebElement getSkipSignInButton() {
		return skipSignInButton;
	}

	public WebElement getCreateAccountRadioButton() {
		return createAccountRadioButton;
	}

	public WebElement getLoginAlreadyACustomerRadioButton() {
		return loginAlreadyACustomerRadioButton;
	}

	public WebElement getEmailOrPhoneTextBox() {
		return emailOrPhoneTextBox;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getShowPasswordCheckBox() {
		return showPasswordCheckBox;
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
		Utilities.tapOnElement(getEmailOrPhoneTextBox());
		getEmailOrPhoneTextBox().sendKeys(userName);
	}
	
	public void clickOnLoginAlreadyACustomerRadioButton() {
		getLoginAlreadyACustomerRadioButton().click();
	}
	
	public void clickOnContinueButton() {
		Utilities.tapOnElement(continueButton);
	}
	
	public void enterPassword(String password) {
		Utilities.tapOnElement(getPasswordTextBox());
		getPasswordTextBox().sendKeys(password);
		
	}
	
	public HomePage clickLoginButton(AndroidDriver<AndroidElement> driver) {
		
		Utilities.tapOnElement(loginButton);
		return new HomePage(driver);
	}

}