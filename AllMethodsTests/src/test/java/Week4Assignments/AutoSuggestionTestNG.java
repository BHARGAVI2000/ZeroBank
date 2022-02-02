package Week4Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoSuggestionTestNG {

	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();  
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
		Thread.sleep(2000);
	}
	@Test
	public void autoSuggestion() throws InterruptedException {
		List<WebElement> listofElements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for (WebElement webElement : listofElements)
		{
			System.out.println(webElement.getText());
			if (webElement.getText().equals("selenium download"))
			{
				webElement.click();
				break;
			}}
	}
	@AfterMethod
	public void closeBrowser()
	{		
		driver.quit();
	}	

}
