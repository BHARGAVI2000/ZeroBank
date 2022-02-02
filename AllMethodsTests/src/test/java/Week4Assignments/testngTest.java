package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class testngTest {
	WebDriver driver;
	
	@Test
	public void TestGoogle() throws InterruptedException {

		//System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		//driver.quit();


	}
	@Test
	public void TestFacebook() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
driver = new ChromeDriver();
	driver.manage().window().maximize();    
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/");
	driver.findElement(By.name("email")).sendKeys("selenium",Keys.ENTER);
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	
	
	}
}