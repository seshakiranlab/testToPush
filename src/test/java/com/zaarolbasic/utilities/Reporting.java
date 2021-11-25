package com.zaarolbasic.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//This is a listener class for Extent Reports
// This extend(inherits) TestListenerAdapter of TestNG
public class Reporting extends TestListenerAdapter {
	
	// This 3 classes coming form Extent Reporter
	// This is the template of the report
	public ExtentHtmlReporter htmlReporter;
	//This is the user information
	public ExtentReports extent;
	// This is the status of the test cases
	public ExtentTest logger;
	
	//This is on start method -- We need to do setting of the report
	// This is also predefined method of TestListenerAdapter
	// As soon as test start this onStart method is started 
	public void onStart(ITestContext testContext)
	{
		// time stamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
		// Name of the Report
		String repName="Test-Report-"+timeStamp+".html";
		// Storing the generated report in the location
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		// loading extent-config.xml
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "kiran");
		
		// Title of the Report
		htmlReporter.config().setDocumentTitle("Zaarol Test Project");
		//name of the Report
		htmlReporter.config().setReportName("Funtional Test Report");
		//location of the cart
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		//Theme of report
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}

	// tr is the testcase name 
	public void onTestSuccess(ITestResult tr)
	{
		// Create a new entry to the report
		logger=extent.createTest(tr.getName());
		// Send pass information to Report with green color highlight
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		//Create a new entry to the report
		logger=extent.createTest(tr.getName());
		// Send fail information to Report with RED color 
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		// Will search for any testcase name tr.getName()
		// if Matched will load in screenshotpath
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		// Create a file object
		File f = new File(screenshotPath);
		
		//Checking file exists or not 
		if(f.exists())
		{
			try {
				// Add screenshot to the report
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	 }
	
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	// Refresh
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
	
	
	
	
	

}
