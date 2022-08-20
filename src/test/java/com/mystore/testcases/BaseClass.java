package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	String url= readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	public String emailAddress = readConfig.getEmail();
	public String password = readConfig.getPassword();
	
	@BeforeClass
	public void setUp(){
		
		switch(browser.toLowerCase())
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		break;
		
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		driver.manage().window().maximize();
		// Implicit wait for 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 // Logging 
		logger= LogManager.getLogger("DatDrivenFramework"); 
		// open URL
		driver.get(url);
		logger.info("Url opened");
	}
	@AfterClass
	public void tearDown(){
		
		driver.quit();	  
	}
	
	//user method to capture screen shot
			public void captureScreenShot(WebDriver driver,String testName) throws IOException
			{
				//step1: convert webdriver object to TakesScreenshot interface
				TakesScreenshot screenshot = ((TakesScreenshot)driver);
				
				//step2: call getScreenshotAs method to create image file
				
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				
				File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
			
				//step3: copy image file to destination
				FileUtils.copyFile(src, dest);
			}
}