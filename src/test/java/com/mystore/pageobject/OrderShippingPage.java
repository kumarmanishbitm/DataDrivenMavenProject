package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {
	
WebDriver ldriver;
	
	public OrderShippingPage(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(id="cgv")
	WebElement termsOfServices;
	
	@FindBy(name = "processCarrier")
	WebElement proceedShipping;
	
	public void selectTermsOfServices(){
		
		termsOfServices.click();
	}
	
	public void clickOnProceedToCheckOut(){
		
		proceedShipping.click();
	}

}
