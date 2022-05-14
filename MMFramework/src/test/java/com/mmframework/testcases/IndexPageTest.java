package com.mmframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmframework.base.BaseClass;
import com.mmframework.dataprovider.DataProviders;
import com.mmframework.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {

		IndexPage indexPage;
		
		@Parameters("browser")
		@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
		public void setup(String browser) {
			//launchApp("IE");
			launchApp(browser);
		}
		
		@Test(groups = "Smoke")
		public void verifyLogo() throws Throwable {
	        indexPage= new IndexPage();
			boolean result=indexPage.validateLogo();
			Assert.assertTrue(result);
			
		}
		@Test(groups = "Smoke")
		public void verifyTitle() {
			String actTitle=indexPage.getWebTitle();
			Assert.assertEquals(actTitle, "My Store");//How do I get the title of the web app?
			
		}

		@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
		public void tearDown() {
			getDriver().quit();
		}
}
