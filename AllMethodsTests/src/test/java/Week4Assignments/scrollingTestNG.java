package Week4Assignments;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scrollingTestNG {

	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void scrolling() throws InterruptedException, IOException {
	driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement Country =driver.findElement(By.xpath("//td[contains(text(),'India')]"));
	JavascriptExecutor Js= (JavascriptExecutor)driver;
	Js.executeScript("arguments[0].scrollIntoView();", Country);
	Thread.sleep(2000);
	String expectedText= "India";
	String actualText=Country.getText();
	Assert.assertEquals(actualText, expectedText);
	//System.out.println(Country.getText());
	File scrImage =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrImage, new File("C:\\ScreenShots\\image.jpg"));
	}
	@AfterMethod
	public void closeBrowser()
	{		
		driver.quit();
	}
}
	
	
