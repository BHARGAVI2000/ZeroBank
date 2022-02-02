package itest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class xtentReports {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest   test;
	@Test
	public void login() {
		
	report= new ExtentReports("C:\\Users\\Aila\\eclipse-workspace\\TestAutomation\\Reports\\report.html");
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
 driver= new ChromeDriver();
	driver.get("http://zero.webappsecurity.com");
	driver.manage().window().maximize();
	
	//String A =driver.getCurrentUrl();
	//System.out.println(A);
	
	
	//WebElement btnSignIn=driver.findElement(By.id("signin_button"));
	//btnSignIn.click();
	test=report.startTest("verify login");
	driver.findElement(By.id("signin_button")).click();
	test.log(LogStatus.INFO, "Clicked SignIn");
	driver.findElement(By.name("user_login")).sendKeys("username");
	driver.findElement(By.id("user_password")).sendKeys("password");
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.id("details-button")).click();
	driver.findElement(By.id("proceed-link")).click();
	String actualTitle = driver.getTitle();
	String expectedTitle= "Zero - Account Summary";
	Assert.assertEquals(actualTitle, expectedTitle);
	driver.quit();
	report.endTest(test);
	report.flush();
	}
	
//	@AfterMethod
//	public void screenshot(ITestResult testResult) throws IOException
//	
//	{ if(testResult.getStatus()== ITestResult.FAILURE) {
//		
//		String path= Screenshots.takeScreenSHOT
//		
		
	
	
}


 