package com.application.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons {
	
	//LoginPage Elements
	
	@FindBy(xpath="//div[@class='login_logo']")
	private WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement UsernameTxtBox;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement PasswordTxtBox;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginBtn;
	
	//LoginPage Actions
	
	public void verifyLogo( ) {
		Assert.assertTrue(checkAvailability(logo));
		report("Logo successfully displayed");
	}
	public void verifyLoginFunctionality(String username, String password) {
		enterInfo( UsernameTxtBox, username);
		enterInfo(PasswordTxtBox, password);
		click(LoginBtn);
		report("User Successfully logged in into the application");
	}


	
	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}


}
