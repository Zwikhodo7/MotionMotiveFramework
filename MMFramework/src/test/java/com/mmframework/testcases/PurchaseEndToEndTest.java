/**
 * 
 */
package com.mmframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mmframework.base.BaseClass;
import com.mmframework.dataprovider.DataProviders;
import com.mmframework.pageobjects.AddToCartPage;
import com.mmframework.pageobjects.AddressPage;
import com.mmframework.pageobjects.IndexPage;
import com.mmframework.pageobjects.LoginPage;
import com.mmframework.pageobjects.OderPage;
import com.mmframework.pageobjects.OrderConfirmationPage;
import com.mmframework.pageobjects.OrderSummaryPage;
import com.mmframework.pageobjects.PaymentPage;
import com.mmframework.pageobjects.SearchResultsPage;
import com.mmframework.pageobjects.ShippingPage;

/**
 * @author znemadodzi
 *
 */
public class PurchaseEndToEndTest extends BaseClass {

	private IndexPage index;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	private LoginPage loginPage;
	private OderPage orderPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummaryPage orderSummaryPage;
	private OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		//launchApp("IE");
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable {
		index = new IndexPage();
		searchResultPage= index.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("3");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage= addToCartPage.clickOnCheckOut();
		loginPage = orderPage.clickOnCheckOut();
		addressPage = loginPage.login1("admin@xyz.com", "admin@123");
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickOnconfirmOrderBtn();
		String actualMsg =orderConfirmationPage.validateConfirmMessage();
		String expectedMsg = "Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);	
	}

}
