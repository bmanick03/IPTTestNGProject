package org.lloyds;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;

public class LloydsLoginValidation extends BaseClass {

	@BeforeClass
	private void beforealltc() {
		openChrome();

	}

	@BeforeMethod
	private void beforetc() throws InterruptedException {
		driver.get("https://lloydspharmacy.com/");
		maxWindow();
		datetime();

	}

	@AfterMethod
	private void aftertc() {
		datetime();

	}

	@Test(priority = 1)
	private void loginWithInvalidUserNameAndValidPassword() throws Exception {

		LoginPojo l = new LoginPojo();
	
		ImplicitWait();
		if (l.getDecCookies().isDisplayed()) {
			mousehover(l.getDecCookies());
			clickActions(l.getDecCookies());
			mousehover(l.getConCookies());
			clickActions(l.getConCookies());
		} else {
			System.out.println("No Cookies Available");
		}
		
		l.getAccount().click();
		fillTextBox(l.getUsername(), "DemoUser1@gmail.com");
		fillTextBox(l.getPassword(), "Password@123");
		toClick(l.getBtnSignIn());

		Assert.assertTrue(driver.getCurrentUrl().contains("challenge"), "Invalid Credentials");
		System.out.println("Password Validation Passed");

	}

	@Test(priority = 2)
	private void loginwithValidUserNameAndInvalidPassword() throws InterruptedException {
		LoginPojo l = new LoginPojo();

		l.getAccount().click();
		ImplicitWait();
		fillTextBox(l.getUsername(), "DemoUser2@gmail.com");
		fillTextBox(l.getPassword(), "Password@123");
		toClick(l.getBtnSignIn());

		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Invalid Credentials");
		System.out.println("Password Validation Passed");

	}

	@Test(priority = 5)
	private void loginWithValidUserNameAndValidPassword() throws InterruptedException {
		LoginPojo l = new LoginPojo();
		
		l.getAccount().click();
		fillTextBox(l.getUsername(), "berlinsrojila03@gmail.com");
		fillTextBox(l.getPassword(), "IPTDemo@123");
		toClick(l.getBtnSignIn());

		Assert.assertTrue(driver.getCurrentUrl().contains("account"), "Invalid Credentials");
		System.out.println("Password Validation Passed");
	}

	@Test(priority = 3)
	private void forgotPassword() {
		LoginPojo l = new LoginPojo();

		l.getAccount().click();
		l.getBtnForgotPassword().click();
		Assert.assertTrue(driver.getTitle().contains("Forgotten"), "Forgot Link Issue");
		System.out.println("Test Case Passed");
	}

	@Test(priority = 4)
	private void createAccount() {
		LoginPojo l = new LoginPojo();

		l.getAccount().click();
		l.getCreateAccount().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("register"), "Create Account Link Issue");
		System.out.println("Test Case Passed");
	}

	@AfterClass
	private void afteralltc() {
		driver.close();
	}

}
