package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserNameVerifyPage {
	
WebDriver ldriver;
	
	public RegisteredUserNameVerifyPage(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement username;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement signOutBtn;
	
	@FindBy(name="search_query")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement submitSearch;
	
	
	public String getUsername(){
		
		String text = username.getText();
		
		return text;
	}
	
	public void clickOnSignOutBtn(){
		signOutBtn.click();
	}
	
	public void enterDataInSearchBox(String searchKey){
		searchBox.sendKeys(searchKey);
	}
	
	public void clickOnSearchBtn(){
		
		submitSearch.click();
	}

}
