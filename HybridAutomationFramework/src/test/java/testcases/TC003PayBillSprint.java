package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.AccountSummaryPage;

import pages.PayBillsPage;

public class TC003PayBillSprint extends BaseClass {
	
	
	@Test
	public void payBillSprint() {
		
		test.log(LogStatus.INFO, "Pay Sprint bill Test started");
		app_logs.info("Pay Sprint bill test started");

		AccountSummaryPage asp=new AccountSummaryPage(driver);
		test.log(LogStatus.INFO, "Clicked PayBills button");
		asp.doClickPayBills();
		
		PayBillsPage pb=new PayBillsPage(driver);
		test.log(LogStatus.INFO, "Clicked Pay Saved Payee button");
		pb.doClickPaySavedPayee();
		
		test.log(LogStatus.INFO, "Entered information in the new Payee form");
		pb.doPaySavedPayee("Sprint");
		pb.doSpAccount("Checking");
		pb.doSpAmount("200");
		pb.doSpDate("2020-06-23");
		pb.doSpDescription("Sprint wireless monthly bill");
		pb.doClickbtnPaySavedPayee();
		
		Assert.assertTrue(pb.alertContainer.isDisplayed());
		app_logs.info("Pay Sprint bill test completed");
		test.log(LogStatus.INFO, "Pay Sprint bill test completed");
		
	}

}
