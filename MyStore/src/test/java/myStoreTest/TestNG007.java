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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG007 {

	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}

	@Test(priority=1)
	public void enterUrl() {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle= "My Store";
		Assert.assertEquals(actualTitle, expectedTitle, "Mystore title displayed");
	}

	@Test(priority=2)
	public void clickWomen() throws InterruptedException, IOException {
		driver.findElement(By.linkText("Women")).click();

		//output Women page with its categories and images should be displayed
		String TopsSubCategories=driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/h5/a")).getText();
		String ExpectedTopsSubcategories="TOPS";
		Assert.assertEquals(TopsSubCategories, ExpectedTopsSubcategories, "Tops link displayed");


		String DressesSubCategories=driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).getText();
		String ExpectedDressesSubCategories="DRESSES";
		Assert.assertEquals(DressesSubCategories, ExpectedDressesSubCategories, "Dresses link displayed");


		Thread.sleep(2000);
		//womens subcategories tops , dresses images displayed
		WebElement WomenSubcategoryimages=driver.findElement(By.id("subcategories"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", WomenSubcategoryimages);
		File srcImage= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcImage, new File("C:\\Screenshot\\img.jpg"));
	}
	@AfterClass
	public void tearDown() {
		driver.close();}

}

