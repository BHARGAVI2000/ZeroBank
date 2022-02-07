package YourStoreTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingUtilities.XTentReport;
import YourStorePages.LoginPage;
import YourStorePages.MyAccountPage;



public class LoginTest extends BaseClass{

	@Test
	public void login()
	{
		Report=XTentReport.getReport();
		test=Report.startTest("Login test started");
		MyAccountPage ap = new MyAccountPage(driver);
		LoginPage lp= new LoginPage(driver);
		test.log(LogStatus.INFO, "click on MyAccount");
		ap.clickMyAccount();
		test.log(LogStatus.INFO, "clicked MyAccount");
		lp.clicklogin();
		lp.setEmailID("saritha740@yahoo.ca");
		lp.setPassword("selenium");
		lp.clickSubmitBtn();
		test.log(LogStatus.INFO, "clicked loginSubmitButton");
		String actualTitle=driver.getTitle();
		String expectedTitle ="My Account";	
		Assert.assertEquals(actualTitle, expectedTitle);

	}
}
