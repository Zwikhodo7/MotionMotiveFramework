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
public class LoginPage extends BaseClass {

Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String Username, String Password) {
		Action.type(userName, Username);
		Action.type(password, Password);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String Username, String Password) {
		Action.type(userName, Username);
		Action.type(password, Password);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
}
