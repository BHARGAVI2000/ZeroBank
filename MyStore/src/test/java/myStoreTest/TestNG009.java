package myStoreTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG009 {
	WebDriver driver;

	//Verify Women with its tops subcategories link
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);}


	@Test(priority=1)
	public void enterUrl() {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle= "My Store";
		Assert.assertEquals(actualTitle, expectedTitle, "Mystore title displayed");}

	@Test(priority=2)
	public void clickWomen() throws InterruptedException
	{

		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);
	}

	@Test(priority =3)
	public void clickTops() throws InterruptedException, IOException {
		driver.findElement(By.linkText("Tops")).click();
		String actualTshirts=driver.findElement(By.linkText("T-shirts")).getText();
		String expectedTshirts="T-Shirts";
		String actualBlouses=driver.findElement(By.linkText("Blouses")).getText();
		String expectedBlouses="Blouses";
		Assert.assertEquals(actualBlouses, expectedBlouses,"Tops subcategories T-shirts, Blouses Links displayed");
		File topsImage=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(topsImage, new File("C:\\Screenshot\\topsimages.jpg"));

		Thread.sleep(2000);
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}}
