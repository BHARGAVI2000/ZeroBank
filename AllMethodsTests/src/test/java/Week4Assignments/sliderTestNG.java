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

public class sliderTestNG {


	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public  void sliderInFrame() throws InterruptedException{   
		driver.get("https://jqueryui.com/slider/");
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//body/div[@id='slider']/span[1]"));
		Actions action= new Actions(driver);
		action.dragAndDropBy(element, 300,0).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Demos')]")).click();
	}

	@Test
	public  void slider2(){  
		driver.get("http://demo.automationtesting.in/Slider.html");
		WebElement element = driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
		Actions act = new Actions(driver);
		//act.dragAndDropBy(element, 500, 0).build().perform();
		act.moveToElement(element).dragAndDropBy(element, 500, 0).build().perform();
	}
	@AfterMethod
	public void closeBrowser()
	{		
		driver.quit();
	}
}
