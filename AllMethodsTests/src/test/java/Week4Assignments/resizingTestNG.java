package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class resizingTestNG {
	
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void resizable1() throws InterruptedException {
	driver.get("https://jqueryui.com/resizable/");
	
	driver.switchTo().frame(0);
	WebElement resizing = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
	Actions action = new Actions(driver);
	action.dragAndDropBy(resizing, 50, 50).perform();
	Thread.sleep(2000);}

@Test
public void resizable2() throws InterruptedException {
	
	driver.get("http://demo.automationtesting.in/Resizable.html");
	//driver.switchTo().frame(0);
	WebElement resizing = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
	Actions action = new Actions(driver);
	action.dragAndDropBy(resizing, 100, 50).perform();
	Thread.sleep(2000);
}
@AfterMethod
public void closeBrowser()
{		
	driver.quit();
}
}