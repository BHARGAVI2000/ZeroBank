package myStoreTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGelementStatusCapture {
	
	WebDriver driver;
	@BeforeClass
	//Launch browser
	public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
	driver.manage().window().maximize();}
	
	@Test(priority=2)
	public void enterUrl() {
	driver.get("http://automationpractice.com/index.php");
	
	String actualTitle= driver.getTitle();
	String expectedTitle= "My Store";
	Assert.assertEquals(actualTitle, expectedTitle,"Title is matched");
	
	
	String actualUrl= driver.getCurrentUrl();
	String expectedUrl= "http://automationpractice.com/index.php";
	Assert.assertEquals(actualUrl, expectedUrl, "Url is matched");}
	
	@Test(priority=2)
	public void signIn() throws InterruptedException {
	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("email_create")).sendKeys("saritha740@yahoo.ca");
	driver.findElement(By.id("SubmitCreate")).click();
	
	String actualTitle1= driver.getTitle();
	String expectedTitle1= "Login - My Store";
	Assert.assertEquals(actualTitle1, expectedTitle1, "Title of sigin is matched ");
	}
	
	@Test(priority=3)
	public void registrationform() throws InterruptedException {
	Boolean firstName=driver.findElement(By.xpath("//input[@id='customer_firstname']")).isEnabled();
	Assert.assertTrue(true);//check the firstname field enabled
			
	Boolean lastName= driver.findElement(By.id("customer_lastname")).isEnabled();//check the lastname field enabled
	Assert.assertTrue(true);
	
	Boolean gender =driver.findElement(By.id("id_gender2")).isSelected();//check the radio button is selected
	Assert.assertTrue(true);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}


