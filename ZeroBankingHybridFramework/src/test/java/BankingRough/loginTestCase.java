package BankingRough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingPages.LoginPage;
import BankingPages.PayBillsPage;
import BankingPages.SignInPage;
import BankingUtilities.TakeScreenShot;


public class loginTestCase extends BaseClass{
	
	public ExtentReports extent;
	public ExtentHtmlReporter  htmlreporter;
	public ExtentTest test;
	
	@BeforeClass
	public void setExtent() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\myTestReport1.html");
		
		htmlreporter.config().setDocumentTitle("Automation Report");
		
		htmlreporter.config().setReportName("Functional Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname","LocalHost");
		extent.setSystemInfo("os","Window10");	
		extent.setSystemInfo("TestName","Saritha");
		extent.setSystemInfo("Browser","Chrome");
	}
	
	@AfterClass
	public void endReport()
	
	{
		extent.flush();
		}
	
				
	      
@Test
	public void login() {
	test=extent.createTest(" ZERO BANKING APPLICATION");
	//test.log(LogStatus.INFO, "add Payee Test started");
	//app_logs.info("add Payee test started");	
	//app_logs.info("SignIn STARTED");
	SignInPage si= new 	SignInPage(driver);
	si.clickSignIn();
	LoginPage lp= new LoginPage(driver);
	lp.enterUserName("username");
	lp.enterPassword("password");
	lp.clickSubmit();
	lp.clickDetailButton();
	lp.clickProceedLink();
	//app_logs.info("add Payee test completed");
	//test.log(LogStatus.INFO, "Add Payee test completed");
	String actualTitle = driver.getTitle();
	String expectedTitle= "Zero - Account Summary1";
	Assert.assertEquals(actualTitle, expectedTitle);
	}

@AfterMethod
public void TestReports(ITestResult result) throws IOException {
	
	if(result.getStatus()== ITestResult.FAILURE) {
		test.log(Status.FAIL, "Login test is failed"+result.getMethod().getMethodName());
		test.log(Status.FAIL,"Login test is faileed"+result.getThrowable());
		String screenshotPath=TakeScreenShot.getScreenShot(driver, result.getName());
		test.addScreenCaptureFromPath(screenshotPath);
	}
		
		else if(result.getStatus()== ITestResult.SKIP) {
			test.log(Status.SKIP, "Login test is skipped"+result.getMethod().getMethodName());}
			
			else if(result.getStatus()== ITestResult.SUCCESS) {
				test.log(Status.PASS, "Login test is Passed"+result.getMethod().getMethodName());
			}
		
	
	
	
}
	
	
	
	
	
	}
	