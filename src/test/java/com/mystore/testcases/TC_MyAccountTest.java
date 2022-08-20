package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetailsPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserNameVerifyPage;


public class TC_MyAccountTest extends BaseClass{
	
	@Test(enabled=false)
	public void verifySignInAndReg(){
			
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("Clicked on SignIn link");
		
		MyAccount mac = new MyAccount(driver);
		mac.enterEmailId("Tsmail12@gmail.com");
		logger.info("Email address entered successfully.");
		
		mac.clickonCreateBtn();
		logger.info("Clicked on Create an account button successfully.");
				
		AccountCreationDetailsPage acd =  new AccountCreationDetailsPage(driver);
		
		acd.selectTitle();
		acd.enterFirstName("Mk");
		acd.enterLastName("kumar");
		acd.enterPassword("mk_123");
		acd.enterAddFname("AddMK");
		acd.enterAddLname("AddKumar");
		acd.enterAddress("18/8 park street");
		acd.enterCityNamecity("Delhi");
		acd.selectState("Alabama");
		acd.enterZip("00000");
		acd.selectCountry("United States");
		acd.enterphoneNumber("9878967656");
		acd.enterAliasName("Home");
		logger.info("Entered all required details for Registration.");
		
		acd.clickonRegBtn();
		
		RegisteredUserNameVerifyPage rnv = new RegisteredUserNameVerifyPage(driver);
		
		String username=	rnv.getUsername();
		
		Assert.assertEquals(username, "Mk kumar");
		
		logger.info("Registration Success");
	}
	
	@Test
	public void verifyLogin() throws IOException{
		
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("Clicked on SignIn link");
		
		MyAccount mac = new MyAccount(driver);
		
		mac.enterRegEmail("Tsmail12@gmail.com");
		mac.enterRegPass("mk_123");
		mac.clickOnLoginBtn();
		
 RegisteredUserNameVerifyPage rnv = new RegisteredUserNameVerifyPage(driver);
		String vusername=	rnv.getUsername();
		
		if(vusername.equals("Mk kumar")){
			
			logger.info("Verify login: Success");
			Assert.assertTrue(true);
		}
		else {
			
			logger.info("Verify login: Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
		
		
	}

}
