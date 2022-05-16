/**
 * 
 */
package com.mmframework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.mmframework.actiondriver.Action;
import com.mmframework.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author znemadodzi
 *
 */
public class IndexPage extends BaseClass {
	

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement Logo;

	@FindBy(id="search_query_top")
	private WebElement searchProductBox;

	@FindBy(name="submit_search")
	private WebElement searchButton;



	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), Logo); //What happens if I change the WebDriver Parameter to WebElement Parameter instead?
	}

	public String getWebTitle() {
		String webTitle = getDriver().getTitle();
		return webTitle;
	}

	public SearchResultsPage searchProduct(String ProductName)throws Throwable {
		Action.type(searchProductBox, ProductName);
		Action.click(getDriver(), searchButton);
		//ExtentTestManager.getTest().log(LogStatus.PASS, " displayed on " );


		return new SearchResultsPage();
	}
}
