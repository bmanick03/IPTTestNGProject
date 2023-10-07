package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//p[contains(text(),'Account')]")
	private WebElement account;
	
	@FindBy(xpath="//a[contains(text(),'Forgot')]")
	private WebElement btnForgotPassword;
	
	@FindBy(xpath="//input[@id=\'email-address\']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id=\'password\']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type=\'submit\']")
	private WebElement btnSignIn;
	
	@FindBy(xpath="//a[text()=\'Create account\']")
	private WebElement createAccount;
	

	
	@FindBy(xpath="(//button[contains(text(),\'Select\')])[2]")
	private WebElement decCookies;
	
	@FindBy(xpath="//button[contains(text(),\'Confirm\')]")
	private WebElement conCookies;
		
	public WebElement getAccount() {
		return account;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}

	public WebElement getBtnForgotPassword() {
		return btnForgotPassword;
	}


	public WebElement getDecCookies() {
		return decCookies;
	}

	public WebElement getConCookies() {
		return conCookies;
	}


}
