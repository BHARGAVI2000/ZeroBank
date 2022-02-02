package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.AccountSummaryPage;

import pages.LoginPage;
import pages.PayBillsPage;

public class TC002AddNewPayee extends BaseClass {
	
	
	@Test
	public void AddPayee() {
		
		test.log(LogStatus.INFO, "add Payee Test started");
		app_logs.info("add Payee test started");
		LoginPage lp=new LoginPage(driver);
		test.log(LogStatus.INFO, "Entered Username and Password");
		lp.doLogin("username", "password");
		AccountSummaryPage asp=new AccountSummaryPage(driver);
		test.log(LogStatus.INFO, "Clicked PayBills button");
		asp.doClickPayBills();
		
		PayBillsPage pb=new PayBillsPage(driver);
		test.log(LogStatus.INFO, "Clicked Add new Payee button");
		pb.doClickAddPayee();
		test.log(LogStatus.INFO, "Entered information in the new Payee form");
		pb.doAddPayee("Telus", "123 45th Ave East", "123456", "cell phone");
		
		Assert.assertTrue(pb.alertContainer.isDisplayed());
		app_logs.info("add Payee test completed");
		test.log(LogStatus.INFO, "Add Payee test completed");
		
	}

}
