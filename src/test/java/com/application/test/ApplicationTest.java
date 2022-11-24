package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pages.CartPage;
import com.application.pages.CompletedPage;
import com.application.pages.LoginPage;
import com.application.pages.OverviewPage;
import com.application.pages.ProductsPage;
import com.application.pages.YourInformationPage;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass {
	
	@Test(priority =1, groups= {"Smoke"})
	public void verifyApplicationLogo() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLogo();
	}
	
	@Test(priority = 2,dataProvider="logindata", groups= {"Smoke","Regression"})
	public void verifyApplicationLoginFunctionality(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		ProductsPage productspage = ProductsPage.getProductsPage();
		loginpage.verifyLoginFunctionality(username, password);
		productspage.verifySuccessfulLogin();

	}
	
	@Test(priority =3, dataProvider="logindata")
	public void verifyClickonAddtoCart(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
	}
	
	@Test(priority =4, dataProvider="logindata")
	public void verifyCart(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
		
		productspage.getCartLink();
		CartPage cartpage = CartPage.getCartPage();
		cartpage.verifySuccessfullyYourCart();
	}
	
	@Test(priority =5, dataProvider="logindata")
	public void verifyClickedOnCheckoutBtn(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
		productspage.getCartLink();
		CartPage cartpage = CartPage.getCartPage();
		cartpage.verifySuccessfullyYourCart();
		
		cartpage.CheckoutBtn();
		YourInformationPage Infopage = YourInformationPage.getYourInformationPage();
		Infopage.verifySuccessfullyYourInfo();
	}
	
	@Test(priority =6, dataProvider="logindata")
	public void AddAllDetails(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
		productspage.getCartLink();
		CartPage cartpage = CartPage.getCartPage();
		cartpage.verifySuccessfullyYourCart();
		cartpage.CheckoutBtn();
		YourInformationPage Infopage = YourInformationPage.getYourInformationPage();
		Infopage.verifySuccessfullyYourInfo();
		
		Infopage.FirstNameTxtBox();
		Infopage.LastNameTxtBox();
		Infopage.ZipPostalCodeTxtBox();
	}
	
	@Test(priority =7, dataProvider="logindata")
	public void verifyClickOnContinue(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
		productspage.getCartLink();
		CartPage cartpage = CartPage.getCartPage();
		cartpage.verifySuccessfullyYourCart();
		cartpage.CheckoutBtn();
		YourInformationPage Infopage = YourInformationPage.getYourInformationPage();
		Infopage.verifySuccessfullyYourInfo();
		Infopage.FirstNameTxtBox();
		Infopage.LastNameTxtBox();
		Infopage.ZipPostalCodeTxtBox();
		
		Infopage.getContinueBtn();
		OverviewPage Ovpage = OverviewPage.getOverviewPage();
		Ovpage.gotOverviewPage();
	}
	
	@Test(priority =8, dataProvider="logindata")
	public void verifyClickOnFinishBtn(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
		productspage.getCartLink();
		CartPage cartpage = CartPage.getCartPage();
		cartpage.verifySuccessfullyYourCart();
		cartpage.CheckoutBtn();
		YourInformationPage Infopage = YourInformationPage.getYourInformationPage();
		Infopage.verifySuccessfullyYourInfo();
		Infopage.FirstNameTxtBox();
		Infopage.LastNameTxtBox();
		Infopage.ZipPostalCodeTxtBox();
		Infopage.getContinueBtn();
		OverviewPage Ovpage = OverviewPage.getOverviewPage();
		Ovpage.gotOverviewPage();
		
		Ovpage.getFinishBtn();
		CompletedPage complete = CompletedPage.getCompletedPage();
		complete.completed();
	}
	
	@Test(priority =9, dataProvider="logindata")
	public void verifySuccessfullyCompleted(String username,String password) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(username, password);
		ProductsPage productspage = ProductsPage.getProductsPage();
		productspage.getAddToCartBtn();
		productspage.getCartLink();
		CartPage cartpage = CartPage.getCartPage();
		cartpage.verifySuccessfullyYourCart();
		cartpage.CheckoutBtn();
		YourInformationPage Infopage = YourInformationPage.getYourInformationPage();
		Infopage.verifySuccessfullyYourInfo();
		Infopage.FirstNameTxtBox();
		Infopage.LastNameTxtBox();
		Infopage.ZipPostalCodeTxtBox();
		Infopage.getContinueBtn();
		OverviewPage Ovpage = OverviewPage.getOverviewPage();
		Ovpage.gotOverviewPage();
		Ovpage.getFinishBtn();
		CompletedPage complete = CompletedPage.getCompletedPage();
		complete.completed();
		
		complete.ClickOnBackHome();
		productspage.verifySuccessfulLogin();
	}
	
	@DataProvider(name="logindata")
	public String [][] readData(){
		String [][] data = ReadExcel.readData("TestData.xlsx", "Sheet1");
		return data;
	}
	
	

}
