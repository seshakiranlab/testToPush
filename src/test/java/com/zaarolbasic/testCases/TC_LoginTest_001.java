package com.zaarolbasic.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zaarolbasic.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	
	
	
	@Test(priority=1)
	public void loginTest_validEmail_validPassword_TC_001() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("...Opened Admin Portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("...Provided User Name");
		lp.setPassword(password);
		logger.info("...Provided Password");
		lp.clickLogin();
		logger.info("...Singned in");
		lp.clickSignOut();
		logger.info("...Signed out");
		Thread.sleep(10000);
		lp.clickLogOut();
		logger.info("...Logged out");
		
		//Thread.sleep(2000);
		/*
		if(driver.getTitle().equals("Wantedly writing wrong"))
		{
			Assert.assertTrue(true);
			logger.info("...This should not print");
		}else {
			captureScreen(driver,"loginTest");
			logger.info("...Login Failed took screenshot");
			Assert.assertTrue(false);
		}
		*/
		
	}
	
	
	
	@Test(priority=2)
	// Providing Invalid user Email & valid password
	public void loginTest_invalidEmail_validPassword_TC_002()
	{
		driver.get(baseURL);
		logger.info("... Opened Admin Portl");
		LoginPage lp = new LoginPage(driver);
		lp.setUserNameWrong(usernameWrongBC);
		logger.info(".. Provided Wrong User name");
		lp.setPassword(password);
		logger.info("... Provided Password");
		lp.clickLogin();
		logger.info("...Singned in");
		lp.findEmailInvalid();
		logger.info("... Found Email is invalid");
		
	}
	
	@Test(priority=3)
	// Providing Invalid user Email & valid password
	public void loginTest_invalidEmail_invalidPassword_TC_003()
	{
		driver.get(baseURL);
		logger.info("... Opened Admin Portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserNameWrong(usernameWrongBC);
		logger.info(".. Provided Wrong User name");
		lp.setPassword(passwordWrongBC);
		logger.info("... Provided Wrong Password");
		lp.clickLogin();
		logger.info("... clicked Singin");
		lp.findEmailInvalid();
		logger.info("... Found Email is invalid");
		
	}
	
	@Test(priority=4)
	public void loginTest_validEmail_EmptyPassword_TC_004()
	{
		driver.get(baseURL);
		logger.info("... Opened Admin Portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("... Provided User name");
		lp.setPasswordEmpty(passwordEmptyBC);
		logger.info("... Provided Empty password");
		lp.clickLogin();
		logger.info("... clicked Signin");
		lp.findEmptyPassword();
		logger.info("... Found Empty password text");
		
	}
	
	
	
	
	@Test(priority=5)
	public void loginTest_invalidEmail_EmptyPassword_TC_005() {
		driver.get(baseURL);
		logger.info("... Opened Admin Portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserNameWrong(usernameWrongBC);
		logger.info("... Provided invalid username");
		lp.setPasswordEmpty(passwordEmptyBC);
		logger.info("... Provided Empty password");
		lp.clickLogin();
		logger.info("... clicked Signin");
		lp.findInvalidEmail_emptyPassword();
		logger.info("... Invalid Email & Empty password");
	}
	@Test(priority=6)
	public void loginTest_EmptyUsername_InvalidPassword_TC_006() {
		driver.get(baseURL);
		logger.info("... Opened Admin Portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserNameEmpty(usernameEmptyBC);
		logger.info("... Providing Empty user name");
		// hear providing wrong password is not taking
		//lp.setPasswordWrong(passwordWrongBC);
		//lp.setPassword(passwordWrongBC);
		logger.info("... Provided Wrong password");
		lp.clickLogin();
		logger.info("... Clicked Signin");
		lp.findPleaseFillEmail();
		logger.info("... Found please fill Email");
		
	}
	
	
	@Test(priority=7)
	public void loginTest_EmptyUsername_EmptyPassword_TC_007() {
		driver.get(baseURL);
		logger.info("... Opened Admin portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserNameEmpty(usernameEmptyBC);
		logger.info("... Entered Empty user name");
		lp.setPasswordEmpty(passwordEmptyBC);
		logger.info("... Provided Empty password");
		lp.clickLogin();
		logger.info("... Clicked sigin");
		lp.findpleaseEnterEmail_password();
		logger.info("... Found please enter EmailID & password");
	}
	
}
