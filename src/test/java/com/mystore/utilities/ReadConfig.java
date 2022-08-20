package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	String path = "D:\\Manish\\DatDrivenFramework\\Configuration\\TestData.properties";
	
	public ReadConfig(){
		
		prop= new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// method to read keys from property file
	
	public String getBaseUrl(){
		String value= prop.getProperty("baseUrl");
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("Url not found in property file");
	}
	
	public String getBrowser(){
		String value= prop.getProperty("browse");
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("Browser not found in property file");
	}
	
	public String getEmail(){
		String email= prop.getProperty("email");
		if(email!=null)
			return email;
		else 
			throw new RuntimeException("Email not found in property file");
	}
	
	public String getPassword(){
		String password= prop.getProperty("password");
		if(password!=null)
			return password;
		else 
			throw new RuntimeException("Password not found in property file");
	}


}
