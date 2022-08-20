package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
WebDriver ldriver;
	
	public OrderConfirmationPage(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']/span[text()='I confirm my order']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")
	WebElement successMsg;
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	public void clickOnConfirmOrder(){
		
		confirmOrder.click();
	}
	
	public String getConfirmOrderSuccessMsg(){
		return(successMsg.getText());
	}
	
	
	public void clickOnSignOutBtn(){
		
		signOut.click();
	}

}
