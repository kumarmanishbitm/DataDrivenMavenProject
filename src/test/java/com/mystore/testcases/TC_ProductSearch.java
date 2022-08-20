package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetailsPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUserNameVerifyPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.utilities.ReadExcelFile;


public class TC_ProductSearch extends BaseClass{

	String searchKey="T-shirts";
	
	@Test(enabled=false)
	public void verifySearchFunctionality() throws IOException{

		String searchKey="T-shirts";

		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("Clicked on SignIn link");

		MyAccount mac = new MyAccount(driver);

		mac.enterRegEmail(emailAddress);
		mac.enterRegPass(password);
		mac.clickOnLoginBtn();

		RegisteredUserNameVerifyPage rnv = new RegisteredUserNameVerifyPage(driver);

		rnv.enterDataInSearchBox(searchKey);
		rnv.clickOnSearchBtn();

		SearchResultPage resultPag = new SearchResultPage(driver);

		String searchResultProductName = resultPag.getSearchResultProductName();

		if(searchResultProductName.contains(searchKey)){

			logger.info("Verify Search product TC: Success");
			Assert.assertTrue(true);
			rnv.clickOnSignOutBtn();
		}
		else {

			logger.info("Verify Search product TC: Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyBuyProduct() throws InterruptedException, IOException{
		
//		logger.info("************* Test Case Buy Product Started **************");
//		
//		// SignIn		
//		IndexPage ip = new IndexPage(driver);
//		ip.clickOnSignIn();
//		logger.info("Clicked on SignIn link");
//		
//		// Eenter Credentials to do login		
//		MyAccount mac = new MyAccount(driver);
//		mac.enterRegEmail(emailAddress);
//		mac.enterRegPass(password);
//		mac.clickOnLoginBtn();
//		logger.info("Clicked on Login button");
//		// Search functionality
//		RegisteredUserNameVerifyPage rnv = new RegisteredUserNameVerifyPage(driver);
//		rnv.enterDataInSearchBox(searchKey);
//		rnv.clickOnSearchBtn();
//		logger.info("Clicked on Search button");
//		
//		SearchResultPage srp = new SearchResultPage(driver);
//		srp.ClickOnMoreLink();
//		logger.info("Clicked on More link");
//		
//		Thread.sleep(5000);
//		
//		// Add product
//		ProductPage pg = new ProductPage(driver);
//		pg.setQuantity("5");
//		pg.setSize("M");
//		pg.clickOnAddToCart();
//		pg.clickOnProceedToCheckOut();
//		logger.info("Clicked on Order Add product proceed to checkout button");
//		
//		// Order Summary
//		OrderSummaryPage oSumm = new OrderSummaryPage(driver);
//		oSumm.clickonProceedToCheckOut();
//		logger.info("Clicked on Order Summary proceed to checkout button");
//		
//		// Order Address pg
//		
//		OrderAddressPage oapg = new OrderAddressPage(driver);
//		oapg.clickonProceedToCheckOut();
//		logger.info("Clicked on Order Address proceed to checkout button");
//		
//		// Order Shipping pg
//		OrderShippingPage ospg = new OrderShippingPage(driver);
//		ospg.selectTermsOfServices();
//		ospg.clickOnProceedToCheckOut();
//		logger.info("Clicked on Order Shipping proceed to checkout button");
//		
//		// Order Payment pg
//		OrderPaymentPage oppg = new OrderPaymentPage(driver);
//		oppg.clickOnPayByChecque();
//		logger.info("Clicked on Order pay by checqe button");
//		
//		// Order Confirmation page
//		OrderConfirmationPage ocpg = new OrderConfirmationPage(driver);
//		ocpg.clickOnConfirmOrder();
//		logger.info("Clicked on Order Confirmation button");
//		
//		String successMsg = ocpg.getConfirmOrderSuccessMsg();
//		
//		if(successMsg.equals("Your order on My Store is complete.")){
//			logger.info("VerifyBuyProduct : Passed. ");
//			Assert.assertTrue(true);
//			ocpg.clickOnSignOutBtn();
//		}
//		else {
//			logger.info("VerifyBuyProduct : Failed. ");
//			captureScreenShot(driver, "VerifyBuyProduct");
//			Assert.assertTrue(false);
//		}
//		
//		logger.info("************* Test Case Buy Product Ends **************");
//				
//	}
		
		logger.info("\n***************TestCase Buy Product started*****************"); 

		//Sign in 
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickOnSignIn();


		//Enter account details- email and password
		MyAccount myAcc = new MyAccount(driver);
		myAcc.enterRegEmail(emailAddress);

		logger.info("User Email and Password entered.");
		myAcc.enterRegPass(password);

		myAcc.clickOnLoginBtn();
		logger.info("Sign In link clicked");

		RegisteredUserNameVerifyPage rnv = new RegisteredUserNameVerifyPage(driver);
		rnv.enterDataInSearchBox("T-shirts");
		logger.info("T-shirt entered in search box");

		rnv.clickOnSearchBtn();
		logger.info("clicked on search button");
		
		// Scroll page
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		
		SearchResultPage searchResultPg = new SearchResultPage(driver);
		searchResultPg.overOnTshirtProduct();
		Thread.sleep(2000);
		searchResultPg.ClickOnMoreLink();
		logger.info("Clicked on more button");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		ProductPage prodPg = new ProductPage(driver);
		prodPg.setQuantity("2");
		logger.info("quantity 2 entereed");

		prodPg.setSize("M");
		logger.info("size M entered");

		prodPg.clickOnAddToCart();
		logger.info("Clicked on add to cart");

		prodPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on product page");


		OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
		orderSumPg.clickonProceedToCheckOut(); 
		logger.info("Clicked on proceed to checkout on order summary page");

		OrderAddressPage orderAddPg = new OrderAddressPage(driver);
		orderAddPg.clickonProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on order address page");

		OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
		orderShippingPg.selectTermsOfServices();
		logger.info("selecged term of service check box");

		orderShippingPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on order shipping page");

		OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
		logger.info(orderPaymentPg.getPageTitle());

		orderPaymentPg.clickOnPayByChecque();
		logger.info("Clicked on pay by cheque");

		OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
		orderConfirmPg.clickOnConfirmOrder();

		logger.info("Clicked on confirmed order");

		String sucessMsg = orderConfirmPg.getConfirmOrderSuccessMsg();

		//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

		if(sucessMsg.equals("Your order on My Store is complete."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

			orderConfirmPg.clickOnSignOutBtn();

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver,"VerifyBuyProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase BuyProduct ends*****************"); 
	}
}
