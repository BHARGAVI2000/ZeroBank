package myStoreTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG001 {
	
	WebDriver driver;
	  
	@BeforeClass
	public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test(priority =1)
	//2.Enter the url of the website and press enter   
	public void login() throws IOException {
	driver.get("http://automationpractice.com/index.php");
	String actualTitle=driver.getTitle();
	String expectedTitle="My Store";
	Assert.assertEquals(actualTitle, expectedTitle);}
	
	
	
	//3.Type in dresses available in the catalog in the search text field then click on search            
    @Test(priority=2)
    public void searchtext() throws InterruptedException, IOException {
	driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts" );
	
	
	
	// Output T-shirts image must be displayed
    String ActualImage=driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).getText();
    String expectedImage="Faded Short Sleeve T-shirts";
	Assert.assertEquals(ActualImage, expectedImage ,"T-shirts image must be displayed");
	File srcImage=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcImage,new File("C:\\Screenshots\\Images.jpg"));
	
    }
	@AfterClass
	public void tearDown(ITestResult testResult) {
		
		
		if(testResult.getStatus()==ITestResult.FAILURE) {
			System.out.println("this test case if failed "+testResult.getMethod().getMethodName() );
		}
		if(testResult.getStatus()==ITestResult.SUCCESS)
		{System.out.println("this testcase if passed"+testResult.getMethod().getMethodName());}
				driver.close();}

}

	    


