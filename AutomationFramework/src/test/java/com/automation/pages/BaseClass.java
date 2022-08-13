package com.automation.pages;
 
import java.io.File;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
public class BaseClass {
 	public WebDriver driver;
 	public ExcelDataProvider excel;
 
 	public ConfigDataProvider config;
 	public ExtentReports report;
 	public ExtentTest logger;
 	
 
 	@BeforeSuite
 	public void setUpSuite() {
     	excel = new ExcelDataProvider();
     	config = new ConfigDataProvider();
     	
     	ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ClassicCRMPRO.html"));
 		report= new ExtentReports();
 		report.attachReporter(extent);
 	
 	}
 
 	@BeforeClass
 	public void setup() {
     	driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingurl());
 	}
 
 	@AfterClass
 	public void tearDown() {
     	BrowserFactory.closeApplication(driver);
 	}
 	
 	@AfterMethod
 	public void tearDownMethod(ITestResult result) {
     	if(result.getStatus()==ITestResult.FAILURE)
     	{
          	Helper.captureScreenShot(driver);
     	}
     	report.flush();
 	}
 
}
