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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG004 {
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
		Assert.assertEquals(actualTitle, expectedTitle);
		String fileName ="MyStore"+getRandomString(4)+".png";
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\"+ fileName));
	}
	//3.Type in dresses that are available in the categories in the  search text field 
	@Test(priority=2)
	public void searchtext() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dresses");// enter dresses in search box
		WebElement	searchitemsuggestion=driver.findElement(By.xpath("//li[contains(text(),'Evening Dresses > Printed Dress')]"));//locator for select item from search suggestion 
		Actions action= new Actions(driver);
		action.moveToElement(searchitemsuggestion).click().build().perform();
		String actualImageText = driver.findElement(By.xpath("//h1[contains(text(),'Printed Dress')]")).getText();
		String expectedImageText ="Printed Dress";
		Assert.assertEquals(actualImageText, expectedImageText,"Printed dress images displayed");
		File srcImage=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcImage,new File("C:\\Screenshots\\Image.jpg"));

	}
	//this for generate random string for the above screenshot to have different filename as 
	//it overwrite on the previous screenshot
	public static String getRandomString(int length) {
		StringBuilder sb= new StringBuilder();
		String characters="abcdefghijklmnopqrstuvwxyz1234567890";
		for(int i=0; i<length;i++) {
			int index =(int)(Math.random()*characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString(); 

	}
	@AfterClass
	public void tearDown() {
		driver.close();}}
