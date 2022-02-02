package myStoreTest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG006 {


	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	//2.Enter the url of the website and press enter
	@Test(priority =1)
	public void login() throws IOException {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle="My Store";
		Assert.assertEquals(actualTitle, expectedTitle);}

	//3.Click on Dresses     
	@Test(priority=2)
	public void clickDresses() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();//3.Click on Dresses               
		//output Dresses page with its subcategories  should be displayed
		WebElement element =driver.findElement(By.xpath("//p[contains(text(),'Subcategories')]"));
		String actualImageText=driver.findElement(By.xpath("//p[contains(text(),'Subcategories')]")).getText();
		String expectedImageText="Subcategories";
		Assert.assertEquals(actualImageText, expectedImageText);
		JavascriptExecutor Js= (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(2000);
		File srcImage=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcImage,new File("C:\\Screenshots\\Images.jpg"));
	}		
	@AfterClass
	public void tearDown() {
		driver.close();}

}







