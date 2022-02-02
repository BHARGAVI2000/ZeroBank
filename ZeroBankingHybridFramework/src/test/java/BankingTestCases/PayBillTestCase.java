package BankingTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BankingBase.BaseClass;
import BankingPages.LoginPage;
import BankingPages.PayBillsPage;
import BankingPages.SignInPage;



public class PayBillTestCase  extends BaseClass{


	static String month= "February 2022";
	static  String day="25";

	@Test
	public void login() throws InterruptedException {
		SignInPage si= new SignInPage(driver);
		LoginPage lp= new LoginPage(driver);
		PayBillsPage pb = new PayBillsPage(driver);
		si.clickSignIn();
		lp.enterUserName("username");
		lp.enterPassword("password");
		lp.clickSubmit();
		lp.clickDetailButton();
		lp.clickProceedLink();

		pb.clickPayBills();
		pb.clickPayee();
		pb.selectCombobox("Wells Fargo");
		pb.selectAccountCombobox("Checking");
		pb.enterAmount("200");
		pb.clickAndSelectdate();
		Thread.sleep(20000);
		pb.enterDescriptionPayment("TD mortgage");

		pb.clickPay();
		String paymentSuccessText=driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span")).getText();
		String expectPaymentSuccessText="The payment was successfully submitted.";
		Assert.assertEquals(paymentSuccessText, expectPaymentSuccessText);

	}}






