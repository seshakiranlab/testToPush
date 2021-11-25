package com.zaarolbasic.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zaarolbasic.pageObjects.LoginPage;
import com.zaarolbasic.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("...Opened Admin Portal");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("...Provided User Name");
		lp.setPassword(pwd);
		logger.info("...Provided Password");
		lp.clickLogin();
		logger.info("...Singned in");
		lp.clickSignOut();
		logger.info("...Signed out");
		Thread.sleep(20000);
		lp.clickLogOut();
		logger.info("...Logged out");
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/zaarol/testData/LoginData.xlsx";
		
		int rownum =XLUtils.getRowCount(path,"Sheet1");
		int colcount =XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
	

}
