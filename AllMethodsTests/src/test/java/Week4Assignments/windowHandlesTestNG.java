package Week4Assignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowHandlesTestNG {

	// this is for multiple window
	WebDriver driver;

	@Test(priority=1)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	}
	@Test(priority=2)
	public void multipleWindow() throws InterruptedException {
		String parentHandle=driver.getWindowHandle();
		System.out.println("parent window- "+parentHandle);
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String>handles=driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equalsIgnoreCase(parentHandle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("firstName")).sendKeys("saritha");
				Thread.sleep(3000);
				driver.close();
			}
		} 
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Aila"); 
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void multipleTab() throws InterruptedException
	{
		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window- " + parentHandle);
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equalsIgnoreCase(parentHandle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("alertBox")).click();
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Aila");
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void closeBrowser()
	{		
		driver.quit();
	}
}
