package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG008 {
	WebDriver driver;

	//Verify Women with mouse hover	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
	}
	@Test(priority=1)
	public void enterUrl() {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle= "My Store";
		Assert.assertEquals(actualTitle, expectedTitle, "Mystore title displayed");
	}
	@Test(priority=2)
	public void clickWomen() throws InterruptedException {            
		WebElement MouseHover=driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]"));		
		Actions action = new Actions(driver);
		action.moveToElement(MouseHover).build().perform();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//li[@class='sfHover']/ul")).getText());
		System.out.println("Women subcategory items appeared");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		}

}


