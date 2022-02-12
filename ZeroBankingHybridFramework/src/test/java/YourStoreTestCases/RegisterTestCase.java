package YourStoreTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import yourStoreBase.BaseClass;
import yourStorePages.LogoutPage;
import yourStorePages.RegisterPage;
import yourStoreUtilities.XTentReport;

public class RegisterTestCase extends BaseClass{
	@Test
	public void Register() throws InterruptedException {
		

		Report=XTentReport.getReport();
		test=Report.startTest("Register test started");
		RegisterPage rp =new RegisterPage(driver);
		LogoutPage lo= new LogoutPage(driver);
		

		rp.clickRegister();
		test.log(LogStatus.INFO, "Clicked Register");
		rp.setFirstName("saritha");
		rp.setLastName("aila");
		test.log(LogStatus.INFO, "Entered firstname, lastname");

		rp.setEmail("viggu1@yahoo.ca");
		rp.setTelephoneNumber("41688899977");
		rp.setPassword("selenium1");
		rp.setConfirmPassword("selenium1");
		test.log(LogStatus.INFO, "Entered email, phone number, password");
		rp.clickAgreecheckbox();
		rp.clickcontinuebtn();
		test.log(LogStatus.INFO, "Clicked Continue");
		String actualText=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		String expectedText="Your Account Has Been Created!";
		Assert.assertEquals(actualText, expectedText);
		test.log(LogStatus.INFO, "Account created successfully");
		lo.clickLogout();

	
	}
}






