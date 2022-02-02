package BankingRough;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingPages.LoginPage;
import BankingPages.SignInPage;
import BankingUtilities.TakeScreenShot;

public class ITestResultClass extends BaseClass{
	
	ExtentReports report;
	ExtentTest test; 
	
	@Test
	public void login() {
			
	report= new ExtentReports("C:\\Users\\Aila\\eclipse-workspace\\ZeroBankingHybridFramework\\test-output\\myReport12.html") ;
	test=	report.startTest("Login Test Started");
	test.log(LogStatus.INFO, "SignIn to be clicked");
	//app_logs.info("add Payee test started");	
	//app_logs.info("SignIn STARTED");
	SignInPage si= new 	SignInPage(driver);
	si.clickSignIn();
	test.log(LogStatus.INFO, "SignIn clicked");
	
	LoginPage lp= new LoginPage(driver);
	test.log(LogStatus.INFO, "UserName & Password to be entered");
	lp.enterUserName("username");
	lp.enterPassword("password");
	test.log(LogStatus.INFO, "UserName & Password entered");
	lp.clickSubmit();
	test.log(LogStatus.INFO, "submit clicked");
	lp.clickDetailButton();
	lp.clickProceedLink();
	
	String actualTitle = driver.getTitle();
	String expectedTitle= "Zero - Account Summary1";
	Assert.assertEquals(actualTitle, expectedTitle);
}	
		@AfterMethod
		public void TestReports(ITestResult result) throws IOException {
			
			if(result.getStatus()== ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, "Login test is failed"+result.getMethod().getMethodName());
				test.log(LogStatus.FAIL,"Login test is faileed"+result.getThrowable());
				String screenshotPath=TakeScreenShot.getScreenShot(driver, result.getName());
				String imagePath=test.addScreenCapture(screenshotPath);
				test.log(LogStatus.FAIL, "Test Failed",imagePath);
			}
				
				else if(result.getStatus()== ITestResult.SKIP) {
					test.log(LogStatus.SKIP, "Login test is skipped"+result.getMethod().getMethodName());}
					
					else if(result.getStatus()== ITestResult.SUCCESS) {
						test.log(LogStatus.PASS, "Login test is Passed"+result.getMethod().getMethodName());
					}			report.endTest(test);
					report.flush();
						}
				
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
	

}
