package com.mmframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmframework.base.BaseClass;
import com.mmframework.dataprovider.DataProviders;
import com.mmframework.pageobjects.HomePage;
import com.mmframework.pageobjects.IndexPage;
import com.mmframework.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		//launchApp("IE");
		launchApp(browser);
	}
	
	
	@Test(groups = "Smoke")
	public void wishListTest() throws Throwable {
		indexPage = new IndexPage(); //Why dont we make this initialization for homePage or loginPage as well?
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryDetailsTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
		
	}
	

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
