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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG011 {


	//Verify Women  subcategories with sort by
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void enterUrl() {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle= "My Store";
		Assert.assertEquals(actualTitle, expectedTitle, "Mystore title displayed");
	}

	@Test(priority=2)
	public void  clickWomen() throws InterruptedException {
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);
	}


	//4.Click on tops subcatogories image and Select the filter in the combo box
	@Test(priority=3)
	public void clickTops() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img")).click();
		WebElement ComboList= driver.findElement(By.id("selectProductSort"));
		//WebElement ComboList= driver.findElement(By.xpath("//select[@id='selectProductSort']"));//combobox locator from chropath 
		Select sortby = new Select(ComboList);
		sortby.selectByVisibleText("Price: Lowest first");
		//sortby.selectByIndex(5);
		Thread.sleep(2000);
		File topsLowPrice=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(topsLowPrice, new File("C:\\Screenshots\\topsImages.jpg"));
		System.out.println("Tops images  displayed as per the lowest price images displayed");}
	@AfterClass
	public void tearDown() {
		driver.close();
	}}

