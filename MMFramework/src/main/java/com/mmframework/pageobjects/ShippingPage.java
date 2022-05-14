/**
 * 
 */
package com.mmframework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmframework.actiondriver.Action;
import com.mmframework.base.BaseClass;

/**
 * @author znemadodzi
 *
 */
public class ShippingPage extends BaseClass {

	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() {
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut(){
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

	
}
