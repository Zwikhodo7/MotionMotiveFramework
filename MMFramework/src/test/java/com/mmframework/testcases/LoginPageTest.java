package com.mmframework.testcases;

import java.io.IOException;

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
import com.mmframework.utility.Log;

public class LoginPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		
		launchApp(browser);
	}


	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	//How do you go about making this method run multiple times using data in sheet?
	@Test(dataProvider="credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void LoginTest(String username, String password) throws IOException {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("Checking in");
		loginPage = indexPage.clickOnSignIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(username,password);
		String actualUrl=homePage.getCurrURL();
		String expectedUrl = "http://automationpractice.com/index.php";
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.endTestCase("LoginTest");
		//test.log(Status.PASS, "Success is my portion");
	}

}
