package com.zaarolbasic.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	// Creating a local Driver
	public WebDriver ldriver;
	
	// constructor will get the rdriver from actual driver
	public LoginPage(WebDriver rdriver)
	{
		// Copying rdriver to ldriver
		ldriver = rdriver;
		//Applying this driver to entire class to this page
		// this is for this page 
		PageFactory.initElements(rdriver, this);
	}
/*	
	// Element of Enter E-Mail field
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/form/div[3]/div[1]/input")
	@CacheLookup
	WebElement txtEmail;
	
	
	
	// Element of Password field
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/form/div[3]/div[2]/span/input")
	@CacheLookup
	WebElement txtPassword;
	
	
	
	// Element of Submit Button
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnSignin;
	
	
	
	// Element of SignOut Button
	//@FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/div[1]/div/div[2]/span/i/svg")
	
	//*[@id="root"]/div[2]/div[2]/div[1]/div/div[2]/span/i/svg
	//div[@class='custom-navbar__right-items-container']//span//i//*[name()='svg']
	//*[@id="root"]/div[2]/div[2]/div[1]/div/div[2]/span/i/svg/g[1]/g/g/path[1]
	//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[2]/span[1]/i[1]/*[1]
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[2]/span[1]/i[1]/*[1]")
	@CacheLookup
	WebElement btnSignOut;
	
	
		
	// Element of LogoutOut Button
	//span[contains(text(),'Logout')]
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	@CacheLookup
	WebElement btnLogOut;	
	
	
		
	
	//ActionMethodes
	// Method to send username in Email Field
	public void setUserName(String uname)
	{
		txtEmail.sendKeys(uname);
	}
	
	// Method to send password in password Field
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	// Method to click Singin
	public void clickLogin() 
	{
		btnSignin.click();
	}
	
	// Method to click SingOut
	public void clickSignOut() 
	{
		btnSignOut.click();
	}
	
	// Method to click logOut
	public void clickLogOut() 
	{
		btnLogOut.click();
	}
	
	
*/	
	
	// Elements 
	By txtEmail =By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[3]/div[1]/input");
	By txtPassword=By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[3]/div[2]/span/input");
	By btnSignin =By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[3]/button");
	By btnSignOut=By.xpath("//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[2]/span[1]/i[1]/*[1]");
	By btnLogOut = By.xpath("//span[contains(text(),'Logout')]");
	By txtInvalidEmail = By.xpath("//span[contains(text(),'E-Mail is invalid')]");
	By txtEmptyPassword = By.xpath("//span[contains(text(),'Please fill the Password')]");
	By txtPleaseFillEmail = By.xpath("//span[contains(text(),'Please fill the E-Mail')]");
	
	//WebElement emailInvalid = driver.findElement(By.xpath("//span[contains(text(),'E-Mail is invalid')]"));
	
	// Action Method
	
	
	
	// Method to send emailiD to emailFeild
	public void setUserName(String uname)
	{
		ldriver.findElement(txtEmail).sendKeys(uname);
	}
	
	//Method to send Wrong email to the emailFeild
	public void setUserNameWrong(String unameWrong)
	{
		ldriver.findElement(txtEmail).sendKeys(unameWrong);
	}
	
	// Method to send userName empty
	public void setUserNameEmpty(String unameEmpty)
	{
		ldriver.findElement(txtEmail).sendKeys(unameEmpty);
	}
	
	// Method to send password in password Field
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	// Method to send Wrong password in password Field
	public void setPasswordWrong(String pwdWrong)
	{
		ldriver.findElement(txtPassword).sendKeys(pwdWrong);
	}
	
	// Method to send password Empty
	public void setPasswordEmpty(String pwdEmpty)
	{
		ldriver.findElement(txtPassword).sendKeys(pwdEmpty);
	}
	
		
	// Method to click Singin
	public void clickLogin() 
	{
		ldriver.findElement(btnSignin).click();
	}
		
	// Method to click SingOut
	public void clickSignOut() 
	{
		ldriver.findElement(btnSignOut).click();
	}
		
	// Method to click logOut
	public void clickLogOut() 
	{
		ldriver.findElement(btnLogOut).click();
	}
		
	// Method to Find invaildEmailID
	public void findEmailInvalid()
	{
		WebElement emailInvalid = ldriver.findElement(txtInvalidEmail);
		System.out.println(emailInvalid.isDisplayed());
				 
		if(emailInvalid.isDisplayed()) 
		{
			Assert.assertTrue(true);
			//System.out.print(true);
		} else {
			Assert.assertTrue(false);
			//System.out.println(false);
		}
	}
	
	//Method to find Empty password
	public void findEmptyPassword()
	{
		WebElement emptyPassword = ldriver.findElement(txtEmptyPassword);
		System.out.println(emptyPassword.isDisplayed());
		
		if(emptyPassword.isDisplayed())
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
	}
	
	
	//Method to find Empty Email
	public void findPleaseFillEmail()
	{
		WebElement pleaseFillEmail = ldriver.findElement(txtPleaseFillEmail);
		System.out.println(pleaseFillEmail.isDisplayed());
		
		if(pleaseFillEmail.isDisplayed())
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	
	//Method to find InvalidEmailID & EmptyPassword
	public void findInvalidEmail_emptyPassword()
	{
		WebElement emailInvalid = ldriver.findElement(txtInvalidEmail);
		System.out.println(emailInvalid.isDisplayed());
		WebElement emptyPassword = ldriver.findElement(txtEmptyPassword);
		System.out.println(emptyPassword.isDisplayed());
		
		if(emailInvalid.isDisplayed() && emptyPassword.isDisplayed())
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//Method to find Empty UserName and Empty password
	public void findpleaseEnterEmail_password()
	{
		WebElement emptyPassword = ldriver.findElement(txtEmptyPassword);
		System.out.println(emptyPassword.isDisplayed());
		
		WebElement pleaseFillEmail = ldriver.findElement(txtPleaseFillEmail);
		System.out.println(pleaseFillEmail.isDisplayed());
		
		if(pleaseFillEmail.isDisplayed() &&  emptyPassword.isDisplayed())
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		
	}
	
	
}
