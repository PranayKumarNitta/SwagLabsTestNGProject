package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class OverviewPage extends WebCommons {
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement Overview;
	
	By byOverview = By.xpath("//span[@class='title']");
	
	public void gotOverviewPage() {
		waitForElement(byOverview);
		report("Overview Page is Successfully Launched");
	}
	
	@FindBy(xpath="//button[@data-test='finish']")
	private WebElement FinishBtn;
	
	public void getFinishBtn() {
		scrollToElement(FinishBtn);
		click(FinishBtn);
		report("Successfully Clicked on Finish Button");
	}
	
	public static OverviewPage getOverviewPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), OverviewPage.class);
	}

	
}
