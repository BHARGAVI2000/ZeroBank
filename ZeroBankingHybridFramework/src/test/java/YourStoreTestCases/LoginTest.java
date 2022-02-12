package YourStoreTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import yourStoreBase.BaseClass;
import yourStorePages.LoginPage;
import yourStoreUtilities.XTentReport;




public class LoginTest extends BaseClass{

	@Test
	public void login()
	{
		Report=XTentReport.getReport();
		test=Report.startTest("Login test started");
    	LoginPage lp= new LoginPage(driver);
		lp.clicklogin();
		test.log(LogStatus.INFO, "clicked login");
		lp.setEmailID("viggu14@yahoo.ca");
		lp.setPassword("selenium1");
		test.log(LogStatus.INFO, "Entered username, password");
		lp.clickSubmitBtn();
		test.log(LogStatus.INFO, "clicked loginSubmitButton");
		String actualTitle=driver.getTitle();
		String expectedTitle ="My Account";	
		Assert.assertEquals(actualTitle, expectedTitle);

	}
}
