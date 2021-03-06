package seleniumAdv2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingJavaScriptPopup {
	private WebDriver driver;
	
	@BeforeTest
	public void setup(){
	//System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");	
	
	//driver=new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	
	
driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/V4/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testcase1() throws InterruptedException{
	driver.findElement(By.name("uid")).sendKeys("mngr379205");
	driver.findElement(By.name("password")).sendKeys("AbYjavE ");
	driver.findElement(By.name("btnLogin")).submit();
	driver.findElement(By.xpath("//a[text()='Delete Customer']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");
	driver.findElement(By.name("AccSubmit")).click();
	Thread.sleep(2000);
	// Switching to Alert
	Alert alert=driver.switchTo().alert();
	// Capturing alert message.
	String alertMessage=driver.switchTo().alert().getText();
	// Displaying alert message
	System.out.println(alertMessage);
	// Accepting alert
	alert.accept();
	}
	@AfterTest
	public void tearDown(){
	driver.quit();
	}
	

}
