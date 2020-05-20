package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.amazon.utilities.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
	private WebElement searchTextBoxOnHomePage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='65-inch tv']")
	private WebElement searchedProduct;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='English - EN']")
	private WebElement englishCheckBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save Changes']")
	private WebElement saveChangesButton;
	
	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public WebElement getEnglishCheckBox() {
		return englishCheckBox;
	}
	
	public void enterDetailsinSearchTextBox(String searchText) {
		Utilities.tapOnElement(searchTextBoxOnHomePage);
		searchTextBoxOnHomePage.sendKeys(searchText);
	}
	
	public void selectProductFromList() {
		Utilities.tapOnElement(searchedProduct);
	}
	
	public void clickOnEnglishCheckbox() {
		Utilities.tapOnElement(englishCheckBox);
	}
	
	public void clickOnSaveChangesButton() {
		Utilities.tapOnElement(saveChangesButton);
	}

}
