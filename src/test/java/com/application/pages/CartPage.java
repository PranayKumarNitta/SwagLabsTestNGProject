package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class CartPage extends WebCommons {
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement YourCart;
	
	By byYourCart = By.xpath("//span[@class='title']");
	
	public void verifySuccessfullyYourCart() {
		waitForElement(byYourCart);
		report("Your Cart Page Is Successfully Launched");
	}
	
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']")
	private WebElement Checkout;
	
	public void CheckoutBtn() {
		click(Checkout);
		report("Successfully Clicked on Checkout Button");
	}
	
	public static CartPage getCartPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), CartPage.class);
	}


}
