package com.zaarolbasic.testCases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.zaarolbasic.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username =readconfig.getUseremail();
	public String password =readconfig.getPassword();
	public String usernameWrongBC = readconfig.getUseremailWrong();
	public String passwordWrongBC = readconfig.getPasswordWrong();
	public String usernameEmptyBC = readconfig.getUseremailEmpty();
	public String passwordEmptyBC = readconfig.getPasswordEmpty();
	public static WebDriver driver;
	
	// Logger to be accessible from every where import for Apache log4j
	// This logger object of Logger class need to be in every method
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		System.out.println("Started");
		// Initializing logger
		logger =Logger.getLogger("Zaarol");
		// Configuring Log4j.properties file
		PropertyConfigurator.configure("Log4j.properties");
		
		//If Browser is chrome browser 
		if(br.equals("chrome")) {
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		
		// Using WebDriverManager instead of regular chrome Driver to setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		}

		// If Browser is Firefox
		else if(br.equals("firefox"))
		{
			// For future development on Firefox
			System.out.println("for future devlopments firefox");
		}
		// If Browser is Firefox
		else if(br.equals("IE"))
		{
			// For future development on IE
			System.out.println("for future devlopments in IE");
		}
		
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	// Take screenShot Method as it used by all
	// tname refers to testcase name
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	

}
