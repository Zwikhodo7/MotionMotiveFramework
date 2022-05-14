package com.mmframework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmframework.actiondriver.Action;
import com.mmframework.base.BaseClass;

public class OrderSummaryPage extends BaseClass {


	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
