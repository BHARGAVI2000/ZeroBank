package YourStoreTestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingUtilities.XTentReport;
import YourStorePages.MyAccountPage;


public class MyAccountTestCase extends BaseClass{
 
	@Test
	public void myAccount() throws InterruptedException {

		Report=XTentReport.getReport();
		test=Report.startTest("Login test started");
		MyAccountPage ap = new MyAccountPage(driver);
		ap.clickMyAccount();
		test.log(LogStatus.INFO, "Clicked MyAccount");
		ap.clickRegister();
		
	}
	}




