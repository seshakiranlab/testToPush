package com.zaarolbasic.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//This file is used to read from config.properties file and write to BaseClass.java
	
	// Predefined class Properties
	Properties pro;
	
	// Constructor 
	public ReadConfig()
	{
		// Accessing config.properties file
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	//For Every variable create an Action method 
	
	//Create a action Method for baseURL
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	//Create a action Method for useremail
	public String getUseremail()
	{
		String username=pro.getProperty("useremail");
		return username;
	}
		
	//Create a action Method for UserEmailWrong
	public String getUseremailWrong()
	{
		String usernameWrong = pro.getProperty("useremailWrong");
		return usernameWrong;
	}
	
	// Create a action Method for UserEmailEmpty
	public String getUseremailEmpty()
	{
		String usernameEmpty = pro.getProperty("useremailEmpty");
		return usernameEmpty;
	}
	
	
	//Create a action Method for password
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	//Create a action Method for passwordWrong
	public String getPasswordWrong()
	{
		String passwordWrong = pro.getProperty("passwordWrong");
		return passwordWrong;
	}
	// Create a action Method for passwordEmpty
	public String getPasswordEmpty()
	{
		String passwordEmpty = pro.getProperty("passwordEmpty");
		return passwordEmpty;
	}
}
