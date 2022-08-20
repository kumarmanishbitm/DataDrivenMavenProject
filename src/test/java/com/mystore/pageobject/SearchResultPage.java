package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver){
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
	WebElement searchResultProduct ;
	
	@FindBy(linkText="More")
	WebElement more;
	
	//action methods on web elements of search result page
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
	}
	
	public void overOnTshirtProduct()
	{
		Actions actionobj = new Actions(ldriver);
		actionobj.moveToElement(searchResultProduct).build().perform();
	}
	
	public void ClickOnMoreLink()
	{
		more.click();

	}
	
	
	
	
	

}
