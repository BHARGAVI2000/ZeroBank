package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG002 {


	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	//2.Enter the url of the website and press enter   
	@Test(priority=1)
	public void login() {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle="My Store";
		Assert.assertEquals(actualTitle, expectedTitle);}

	//3.Type in dresses not available in the catalog in the search text field then click on search
	@Test(priority=2)
	public void searchtext() throws InterruptedException {
		driver.findElement(By.id("search_query_top")).sendKeys("kurtis" );
		driver.findElement(By.name("submit_search")).click();
		String actualText=   driver.findElement(By.xpath("//p[contains(text(),'No results were found for your search \"kurtis\"')]")).getText();
		String expectedText="No results were found for your search \"kurtis\"";
		Assert.assertEquals(actualText, expectedText);}

	@AfterClass
	public void tearDown() {
		driver.close();}

}
