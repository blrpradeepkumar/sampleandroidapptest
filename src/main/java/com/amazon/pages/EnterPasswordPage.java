package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnterPasswordPage {
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement passwordTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']")
	public WebElement loginButton;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Show password']")
	public WebElement showPasswordCheckBox;
	
	public EnterPasswordPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void enterPassword(String password) {
		Utilities.tapOnElement(passwordTextBox);
		passwordTextBox.sendKeys(password);
		
	}
	
	public void clickLoginButton() {
		
		Utilities.tapOnElement(loginButton);
	}	

}
