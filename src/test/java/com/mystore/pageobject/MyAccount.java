package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	// Create objects of WebDriver
	
		WebDriver ldriver;
		
		// constructor
		
		public MyAccount(WebDriver rdriver){
			
			ldriver = rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="email_create")
		WebElement createEmailAddress;
		
		@FindBy(id="SubmitCreate")
		WebElement createAnAccountBtn;
		
		@FindBy(id="email")
		WebElement registeredUserEmail;
		
		@FindBy(id="passwd")
		WebElement registeredUserPass;
		
		@FindBy(id="SubmitLogin")
		WebElement loginBtn;
		
		public void enterEmailId(String emailId){
			createEmailAddress.sendKeys(emailId);
		}
		
		public void clickonCreateBtn(){
			createAnAccountBtn.click();
		}
		
		public void enterRegEmail(String loginEmail){
			registeredUserEmail.sendKeys(loginEmail);
		}
		
		public void enterRegPass(String loginPass){
			registeredUserPass.sendKeys(loginPass);
		}
		
		public void clickOnLoginBtn(){
			loginBtn.click();
		}
		

}
