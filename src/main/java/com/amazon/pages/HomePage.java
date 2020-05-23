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
		Utilities.tapOnElement(getSearchTextBoxOnHomePage());
		getSearchTextBoxOnHomePage().sendKeys(searchText);
	}

	public SearchPage selectProductFromList(AndroidDriver<AndroidElement> driver) {
		Utilities.tapOnElement(searchedProduct);
		return new SearchPage(driver);
	}

	public void clickOnEnglishCheckbox() {
		Utilities.tapOnElement(getEnglishCheckBox());
	}

	public void clickOnSaveChangesButton() {
		Utilities.tapOnElement(getSaveChangesButton());
	}

	public WebElement getSearchTextBoxOnHomePage() {
		return searchTextBoxOnHomePage;
	}

	public WebElement getSearchedProduct() {
		return searchedProduct;
	}

	public WebElement getSaveChangesButton() {
		return saveChangesButton;
	}

}
