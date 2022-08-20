package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationDetails1 {

	// Create objects of WebDriver

	WebDriver ldriver;

	// constructor

	public AccountCreationDetails1(WebDriver rdriver){

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="id_gender1")
	WebElement titleMRs;

	@FindBy(id="customer_firstname")
	WebElement firstName;

	@FindBy(id="customer_lastname")
	WebElement lastName;

	@FindBy(id="passwd")
	WebElement password;

	@FindBy(id="firstname")
	WebElement addFirstname;

	@FindBy(id="lastname")
	WebElement addLastname;

	@FindBy(id="address1")
	WebElement address;

	@FindBy(id="city")
	WebElement city;

	@FindBy(id="id_state")
	WebElement state;

	@FindBy(id="postcode")
	WebElement postCode;

	@FindBy(id="id_country")
	WebElement country;

	@FindBy(id="phone_mobile")
	WebElement mobile;

	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(id="submitAccount")
	WebElement registrationBtn;

	public void selectTitle(){
		titleMRs.click();
	}

	public void enterFirstName(String fname){
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname){
		lastName.sendKeys(lname);
	}
	public void enterPassword(String pwd){
		password.sendKeys(pwd);
	}
	public void enterAddrFirstName(String addFname){
	//	addFirstname.clear();
		addFirstname.sendKeys(addFname);
	}
	public void enterAddrLastName(String addLname){
	//	addFirstname.clear();
		addLastname.sendKeys(addLname);
	}
	public void enterAddress(String Address){
		address.sendKeys(Address);
	}
	public void selectState(String text){
		Select obj= new Select(state);
		obj.selectByVisibleText(text);
	}

	public void enterCity(String cityName){
		city.sendKeys(cityName);
	}

	public void enterpostCode(String PostCode){
		postCode.sendKeys(PostCode);
	}

	public void selectCountry(String text){
		Select objC= new Select(country);
		objC.selectByVisibleText(text);
	}
	public void entermobile(String mobileNo){
		mobile.sendKeys(mobileNo);
	}

	public void enterAlias(String aliasName){
		alias.clear();
		alias.sendKeys(aliasName);
	}
	
	public void clickRegBtn(){
		registrationBtn.click();
	}


}
