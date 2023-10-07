package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSelectionPojo extends BaseClass{

	public ProductSelectionPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="(//button[@class=\'a54b28 e56dc2\'])[1]")
	private WebElement shopMenu1;
	
	
	@FindBy(xpath="//span[contains(text(),'Allergy')]")
	private WebElement subMenu1;
	
	@FindBy(xpath="(//a[text()=\'Allergy syrups\'])[2]")
	private WebElement subMenu2;
	
	

	@FindBy(xpath="(//a[text()=\'View details\'])[1]")
	private WebElement viewDetails;
	
	@FindBy(xpath="//button[text()=\'Add to basket\']")
	private WebElement addToCart;
	
	@FindBy(xpath="//button[@class=\\\"dd57c1 e56dc2\\\"]")
	private WebElement verifyCart;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement qnVerifyCart;

	public WebElement getQnVerifyCart() {
		return qnVerifyCart;
	}

	public WebElement getViewDetails() {
		return viewDetails;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getVerifyCart() {
		return verifyCart;
	}

	public WebElement getShopMenu1() {
		return shopMenu1;
	}

	public WebElement getSubMenu1() {
		return subMenu1;
	}

	public WebElement getSubMenu2() {
		return subMenu2;
	}
	
	
}
