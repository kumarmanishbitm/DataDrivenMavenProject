package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	// Create objects of WebDriver
	
	WebDriver ldriver;
	
	// constructor
	
	public IndexPage(WebDriver rdriver){
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// Identify WebElements
	
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	// Identify Action on WebElement
	
	public void clickOnSignIn(){
		
		signIn.click();
	}

}
