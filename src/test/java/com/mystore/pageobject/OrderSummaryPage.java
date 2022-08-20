package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	
WebDriver ldriver;
	
	public OrderSummaryPage(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceedToCheckOutorderSumm;
	
	public void clickonProceedToCheckOut(){
		
		proceedToCheckOutorderSumm.click();
	}

}
