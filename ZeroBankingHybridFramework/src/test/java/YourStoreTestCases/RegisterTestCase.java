package YourStoreTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BankingBase.BaseClass;
import BankingUtilities.XTentReport;
import YourStorePages.LogoutPage;
import YourStorePages.MyAccountPage;
import YourStorePages.RegisterPage;


public class RegisterTestCase extends BaseClass{

	@Test
	public void Register() throws InterruptedException {

		Report=XTentReport.getReport();
		test=Report.startTest("Login test started");
		MyAccountPage ap= new MyAccountPage(driver);
		RegisterPage rp =new RegisterPage(driver);

		LogoutPage lo= new LogoutPage(driver);
		ap.clickMyAccount();
		test.log(LogStatus.INFO, "Clicked MyAccount");

		rp.clickRegister();
		test.log(LogStatus.INFO, "Clicked Register");
		rp.setFirstName("saritha");
		rp.setLastName("aila");
		test.log(LogStatus.INFO, "Entered firstname, lastname");

		rp.setEmail("saritha740@yahoo1.ca");
		rp.setTelephoneNumber("41688899977");
		rp.setPassword("selenium");
		rp.setConfirmPassword("selenium");

		rp.clickAgreecheckbox();
		rp.clickcontinuebtn();
		test.log(LogStatus.INFO, "Account created successfully");
		test.log(LogStatus.INFO, "clicked loginSubmitButton");
		String actualTitle=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		String expectedTitle ="Your Account Has Been Created!";	
		Assert.assertEquals(actualTitle, expectedTitle);
		lo.clickLogout();

		
	}
}






