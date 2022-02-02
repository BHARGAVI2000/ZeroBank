package BankingTestCases;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingPages.LoginPage;
import BankingPages.PayBillsPage;
import BankingPages.SignInPage;
import BankingUtilities.TakeScreenShot;
import BankingUtilities.XTentReport;


@Listeners(BankingRough.TestNGListener1.class)

public class LoginTest extends BaseClass{


	// this login testcase with invalid data or make it valid data  and using listener annotation

	@Test
	public void login() {
		Report=XTentReport.getReport();

		test=Report.startTest("Login Test started");
		test.log(LogStatus.INFO, "add Payee Test started");

		SignInPage si= new 	SignInPage(driver);
		LoginPage lp= new LoginPage(driver);
		
		si.clickSignIn();
		test.log(LogStatus.INFO, "Clicked SignIn");
		
		lp.enterUserName("username");
		lp.enterPassword("password");
		lp.clickSubmit();
		test.log(LogStatus.INFO, "Entered username,password, clicked submit");
		lp.clickDetailButton();
		lp.clickProceedLink();
		test.log(LogStatus.INFO, "Login successful");
		test.log(LogStatus.INFO, "Add Payee test completed");
		String actualTitle = driver.getTitle();
		String expectedTitle= "Zero - Account Summary1";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}





