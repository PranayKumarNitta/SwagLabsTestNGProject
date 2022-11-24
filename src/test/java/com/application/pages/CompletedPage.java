package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class CompletedPage extends WebCommons {
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement Complete;
	
	By byYourCart = By.xpath("//span[@class='title']");

	public void completed() {
		scrollToElement(Complete);
		waitForElement(byYourCart);
		report("Completed Page Successfully Launched");
	}
	
	@FindBy(xpath="//button[@id='back-to-products']")
	private WebElement BackHome;
	
	public void ClickOnBackHome() {
		scrollToElement(BackHome);
		click(BackHome);
		report("Successfully Clicked on Back Home Button");
	}
	
	public static CompletedPage getCompletedPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), CompletedPage.class);
	}

}
