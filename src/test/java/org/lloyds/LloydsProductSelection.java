package org.lloyds;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;
import org.utilities.ProductSelectionPojo;

public class LloydsProductSelection extends BaseClass {

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

	@Test
	private void productSelection() throws InterruptedException {
		LoginPojo l = new LoginPojo();
		ProductSelectionPojo p = new ProductSelectionPojo();
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
		fillTextBox(l.getUsername(), "berlinsrojila03@gmail.com");
		fillTextBox(l.getPassword(), "IPTDemo@123");
		toClick(l.getBtnSignIn());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		mousehover(p.getShopMenu1());
		mousehover(p.getSubMenu1());
		clickActions(p.getSubMenu2());

		toClick(p.getViewDetails());

		toClick(p.getAddToCart());

		Assert.assertTrue(p.getQnVerifyCart().isEnabled(), "Products not added properly");
		System.out.println("Product added to cart Successfully");

	}

	@AfterClass
	private void afteralltc() {
		closeBrowser();
	}

}