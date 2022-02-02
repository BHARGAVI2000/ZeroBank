package myStoreTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG010 {
	WebDriver driver;
	//Verify Women with its tops subcategories link
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
		Assert.assertEquals(actualTitle, expectedTitle, "Mystore title displayed");}

	@Test(priority=2)
	public void  clickWomen() throws InterruptedException {

		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void clickTops() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img")).click();

		// Tops subcategories T-shirts, Blouses imagetext and images should display
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.linkText("T-shirts")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).getText());
		File topsSubcategoriesImages=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(topsSubcategoriesImages, new File("C:\\Screenshots\\topsImages.jpg"));
		System.out.println("Tops subcategories T-shirts, Blouses imagetext and images displayed");	
	}	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
