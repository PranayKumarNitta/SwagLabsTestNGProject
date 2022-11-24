package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class YourInformationPage extends WebCommons {
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement YourInfo;
	
	By byYourInfo = By.xpath("//span[@class='title']");
	
	public void verifySuccessfullyYourInfo() {
		waitForElement(byYourInfo);
		report("Successfully Your Info Page is Launched");
	}
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@placeholder='Zip/Postal Code']")
	private WebElement ZipPostalCode;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement ContinueBtn;
	
	public void FirstNameTxtBox() {
		click(FirstName);
		FirstName.clear();
		FirstName.sendKeys("abc");
		report("First Name Successfully Entered");
	}
	
	public void LastNameTxtBox() {
		click(LastName);
		LastName.clear();
		LastName.sendKeys("xyz");
		report("Last Name Successfully Entered");

	}
	
	public void ZipPostalCodeTxtBox() {
		click(ZipPostalCode);
		ZipPostalCode.clear();
		ZipPostalCode.sendKeys("12345");
		report("Zip/Postal Code Successfully Entered");

	}
	
	public void getContinueBtn() {
		click(ContinueBtn);
		report("Successfully Clicked on Continue Button");
	}
	
	public static YourInformationPage getYourInformationPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), YourInformationPage.class);
	}

}

