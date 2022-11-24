package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class ProductsPage extends WebCommons {
	//Products Page Elements
	
	@FindBy(xpath="//span[text()='Products']")
	private WebElement Products;
	
	By byProducts = By.xpath("//span[text()='Products']");
	
	public void verifySuccessfulLogin() {
		waitForElement(byProducts);
		report("Application login is successful");
	}
	
	@FindBy(xpath="//div[text()='29.99']/following-sibling::button[@class='btn btn_primary btn_small btn_inventory']")
	private WebElement AddToCart;
	
	By byAddToCart = By.xpath("//div[text()='29.99']/following-sibling::button[@class='btn btn_primary btn_small btn_inventory']");

	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement CartLink;
	
	public void getAddToCartBtn() {
		waitForElement(byAddToCart);
		click(AddToCart);
		report("Successfully Clicked on Add To Cart Button");
	}
	
	public void getCartLink() {
		click(CartLink);
		report("Successfully Product Added to Cart");
	}

	
	public static ProductsPage getProductsPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ProductsPage.class);
	}
	
}
