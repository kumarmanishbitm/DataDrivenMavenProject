package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetailsPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserNameVerifyPage;
import com.mystore.utilities.ReadExcelFile;


public class TC_MyAccountTestDatadriven extends BaseClass{
	
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
	
	@Test(dataProvider="loginDataprovider")
	public void verifyLogin(String userEmail, String userPawd, String expectedUsername) throws IOException{
		
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("Clicked on SignIn link");
		
		MyAccount mac = new MyAccount(driver);
		
		mac.enterRegEmail(userEmail);
		mac.enterRegPass(userPawd);
		mac.clickOnLoginBtn();
		
 RegisteredUserNameVerifyPage rnv = new RegisteredUserNameVerifyPage(driver);
		String vusername=	rnv.getUsername();
		
		if(vusername.equals(expectedUsername)){
			
			logger.info("Verify login: Success");
			Assert.assertTrue(true);
			rnv.clickOnSignOutBtn();
		}
		else {
			
			logger.info("Verify login: Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}	
	}
	
	@DataProvider(name = "loginDataprovider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}
		}
		return data;
	}

}
