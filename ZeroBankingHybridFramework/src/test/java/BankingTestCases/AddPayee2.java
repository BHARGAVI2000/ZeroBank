package BankingTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingPages.AddPayeePage;
import BankingPages.LoginPage;
import BankingPages.SignInPage;
import BankingUtilities.XTentReport;


public class AddPayee2 extends BaseClass{

	SignInPage si;
	LoginPage lp ;
	AddPayeePage ap;

// add payee with testng , report, with valid test and invalid test
	@Test(priority=1)
	public void login() throws InterruptedException {

		Report=XTentReport.getReport();
		test=Report.startTest("Login test stared");

		si= new SignInPage(driver);
		lp = new LoginPage(driver);
		ap=new AddPayeePage(driver);


		si.clickSignIn();
		test.log(LogStatus.INFO, "Clicked SignIn");


		lp.doLogin("username", "password");
		test.log(LogStatus.INFO, "Entered username,password, clicked submit");
		lp.clickDetailButton();
		lp.clickProceedLink();
		test.log(LogStatus.INFO, "Login successful");
		String actualTitle = driver.getTitle();
		String expectedTitle= "Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority=2)
	public void addPayee() throws InterruptedException {
		test=Report.startTest("Login test stared");
		test.log(LogStatus.INFO, "click Paybills");
		ap.clickPaybills();
		ap.clickAddNewPayee();
		ap.enterPayee("saritha");
		ap.enterPayeeAddress("40 brampton ");
		ap.enterPayeeAccount("122222222");
		ap.enterPayeeDetails("hydroOne utility");
		test.log(LogStatus.INFO, "Entered Payee details");
		ap.clickAddBtn();
		test.log(LogStatus.INFO, "AddPayee Successful");

		String ActualText= driver.findElement(By.id("alert_content")).getText();
		String ExpectedText="The new payee saritha was successfully created1.";
		Assert.assertEquals(ActualText,ExpectedText);

	}
	
}














