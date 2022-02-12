package YourStoreRough;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentReports {
	WebDriver driver;
	public ExtentReports extent;
	public ExtentHtmlReporter  htmlreporter;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\myReport.html");
		
		htmlreporter.config().setDocumentTitle("Automation Report");
		
		htmlreporter.config().setReportName("Functional Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname","LocalHost");
		extent.setSystemInfo("os","Window10");	
		extent.setSystemInfo("TestName","Saritha");
		extent.setSystemInfo("Browser","Chrome");
	}
	
	@AfterTest
	public void endReport()
	
	{
		extent.flush();
		}
	@BeforeMethod
	public void launchBrowser() 
	{
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 	
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);	
			driver.get("http://zero.webappsecurity.com/index.html");		   
												
				
	}          @Test
				public void zeroBankingTitleTest() {
				test=extent.createTest("zeroBankingTitleTest");
				
//				driver.findElement(By.id("signin_button")).click();
//				driver.findElement(By.id("user_login")).sendKeys("username");
//				driver.findElement(By.id("user_password")).sendKeys("password");
//				driver.findElement(By.name("submit")).click();
//					
//				driver.findElement(By.id("details-button")).click();
//				driver.findElement(By.id("proceed-link")).click();
				
				String actualTitle = driver.getTitle();
				String expectedTitle= "Zero - Personal Banking - Loans - Credit Cards";
				Assert.assertEquals(actualTitle, expectedTitle);}
	


@Test
public void zeroBankingLogoTest() {
	
	test=extent.createTest(" ZERO BANKING APPLICATION LOGO");
	Boolean status=driver.findElement(By.xpath("//*[@id=\"carousel\"]/div/div[1]/img")).isDisplayed();
	Assert.assertTrue(status);	
	
}

@Test
public void zeroBankingLoginTest() {
	test=extent.createTest(" ZERO BANKING LOGIN TEST");
	Assert.assertTrue(true);	
	
}


@AfterMethod
public void tearDown(ITestResult result) throws IOException {
if(result.getStatus()==ITestResult.FAILURE) {
	test.log(Status.FAIL, "Test Case failed is "+ result.getName());
	test.log(Status.FAIL, "Test Case failed is"+result.getThrowable());
	String screenshotPath= extentReports.getScreenshot(driver, result.getName());
	test.addScreenCaptureFromPath(screenshotPath);
}
	else if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP, "Test Case skipped is "+ result.getName());
	}

				else if(result.getStatus()==ITestResult.SUCCESS) {
					test.log(Status.PASS, "Test Case passed is "+ result.getName());

}
driver.quit();
}
public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	String dateName= new SimpleDateFormat("yyymmddhhmmss").format(new Date());
	
	//File srcImage=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(srcImage,new File("C:\\Screenshots\\Images.jpg"));
	TakesScreenshot ts =(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destination =System.getProperty("user.dir")+"/Screenshots/"+screenshotName+dateName+".png";
	File finaldestination=new File(destination);
	FileUtils.copyFile(source, finaldestination);
	return destination;
	
	
}

}

